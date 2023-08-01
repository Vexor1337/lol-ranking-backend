package com.porek.lol.ranking.infrastructure.adapter

import arrow.core.Either
import arrow.core.flatMap
import arrow.core.left
import arrow.core.right
import com.porek.lol.ranking.infrastructure.client.GetSummonerRankInfo
import com.porek.lol.ranking.infrastructure.client.RiotFeignClient
import com.porek.lol.ranking.infrastructure.mapper.toSummonerDto
import com.porek.lol.ranking.ports.output.*
import com.porek.lol.ranking.ports.output.clients.RiotClient
import com.porek.lol.ranking.ports.output.persistance.SummonerDto
import feign.FeignException
import org.springframework.stereotype.Repository

@Repository
class RiotClientAdapter(private val riotFeignClient: RiotFeignClient) : RiotClient {
    override fun getPlayerRankFromApiBySummonerName(summonerName: String): Either<RiotFeignClientError, SummonerDto> {
        return when (val listOfAllSummonerRanks = getAllSummonerRank(summonerName)) {


            is Either.Right -> (listOfAllSummonerRanks.value.find { it.queueType == "RANKED_SOLO_5x5" }?.toSummonerDto()
                ?: SummonerDto(summonerName = summonerName, rank = "UNKNOWN SOLOQ RANK")).right()

            is Either.Left -> listOfAllSummonerRanks.value.left()
        }
    }

    // todo Obsłużyć wszystkie wyjątki
    fun getEncryptedSummonerName(summonerName: String): Either<RiotFeignClientError, String> {
        return Either.catch {
            riotFeignClient.getEncryptedSummonerName(summonerName).id
        }.mapLeft { e ->
            when (e) {
                is FeignException.Forbidden -> RiotFeignClientForbiddenException()
                is FeignException.ServiceUnavailable -> RiotFeignClientServiceUnavailable()
                is FeignException.NotFound -> SummonerNameNotFoundInRiotApi(summonerName)
                is FeignException.Unauthorized -> RiotFeignClientUnauthorizedException()
                else -> RiotFeignClientGenericError("UnexpectedError", e.stackTrace.map { it.toString() })
            }

        }
    }

    fun getAllSummonerRank(summonerName: String): Either<RiotFeignClientError, List<GetSummonerRankInfo>> {
        return getEncryptedSummonerName(summonerName)
            .flatMap { encryptedSummonerName ->
                riotFeignClient.getSummonerRankInfo(encryptedSummonerName).right()
            }
    }
    /*        val encryptedSummonerName = getEncryptedSummonerName(summonerName).getOrElse {
            RiotFeignClientGenericError(message = "Nie udało się znaleźć w Api przywoływacza $summonerName")
        }
        return Either.catch {
            riotFeignClient.getSummonerRankInfo(encryptedSummonerName as String)
        }.mapLeft { e ->
            when (e) {
                is FeignException.NotFound -> SummonerNameNotFoundInRiotApi(summonerName)
                else -> RiotFeignClientGenericError("Error")
            }
        }*/
    }