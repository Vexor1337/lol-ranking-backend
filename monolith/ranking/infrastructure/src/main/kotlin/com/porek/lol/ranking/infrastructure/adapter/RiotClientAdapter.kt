package com.porek.lol.ranking.infrastructure.adapter

import arrow.core.*
import com.porek.lol.ranking.infrastructure.client.GetSummonerRankInfo
import com.porek.lol.ranking.infrastructure.client.RiotFeignClient
import com.porek.lol.ranking.infrastructure.mapper.toSummonerDto
import com.porek.lol.ranking.ports.output.SystemExceptions
import com.porek.lol.ranking.ports.output.clients.RiotClient
import com.porek.lol.ranking.ports.output.persistance.SummonerDto
import feign.FeignException
import org.springframework.stereotype.Repository

@Repository
class RiotClientAdapter(private val riotFeignClient: RiotFeignClient) : RiotClient {
    /*    override fun getPlayerRankFromApiBySummonerName(summonerName: String): Either<SystemExceptions.RiotFeignClientError, SummonerDto> {
        return when(val listOfAllSummonerRanks = getAllSummonerRank(summonerName)) {
            is Either.Right -> {
                val rankedSoloSummonerRank = listOfAllSummonerRanks.value.find { it.queueType == "RANKED_SOLO_5x5" }
                rankedSoloSummonerRank?.toSummonerDto() ?: SummonerDto(summonerName = summonerName, rank = "UNKNOWN SOLOQ RANK")
            }.right()

            is Either.Left -> SystemExceptions.RiotFeignClientGenericError("Ranked solo 5x5 rank not found.").left()
        }
        }*/
    override fun getPlayerRankFromApiBySummonerName(summonerName: String): Either<SystemExceptions.RiotFeignClientError, SummonerDto> {
        return when (val listOfAllSummonerRanks = getAllSummonerRank(summonerName)) {


            is Either.Right -> (listOfAllSummonerRanks.value.find { it.queueType == "RANKED_SOLO_5x5" }?.toSummonerDto()
                ?: SummonerDto(summonerName = summonerName, rank = "UNKNOWN SOLOQ RANK")).right()

            is Either.Left -> SystemExceptions.RiotFeignClientGenericError("Ranked solo 5x5 rank not found.").left()
        }
    }

    fun getEncryptedSummonerName(summonerName: String): Either<SystemExceptions.RiotFeignClientGenericError, String> {
        return try {
            riotFeignClient.getEncryptedSummonerName(summonerName).id.right()
        } catch (e: FeignException) {
            SystemExceptions.RiotFeignClientGenericError(e.localizedMessage).left()
        }
    }

    fun getAllSummonerRank(summonerName: String): Either<SystemExceptions.RiotFeignClientError, List<GetSummonerRankInfo>> {
        val encryptedSummonerName = getEncryptedSummonerName(summonerName).getOrElse {
            SystemExceptions.RiotFeignClientGenericError(message = "Nie udało się znaleźć w Api przywoływacza $summonerName")
        }
        return try {
            riotFeignClient.getSummonerRankInfo(encryptedSummonerName as String).right()
        } catch (e: FeignException) {
            SystemExceptions.RiotFeignClientGenericError(e.localizedMessage).left()
        }
    }
}