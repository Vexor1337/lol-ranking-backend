package com.porek.lol.ranking.application

import arrow.core.Either
import com.porek.lol.ranking.application.mapper.Mapper
import com.porek.lol.ranking.application.mapper.RiotFeignClientErrorMapper
import com.porek.lol.ranking.ports.input.*
import com.porek.lol.ranking.ports.input.service.RankingService
import com.porek.lol.ranking.ports.output.clients.RiotClient
import com.porek.lol.ranking.ports.output.repository.PlayersRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service

@Service
class RankingServiceImpl(
    private val playersRepository: PlayersRepository,
    private val riotClient: RiotClient
) : RankingService {
    private val mapper = Mappers.getMapper(Mapper::class.java)
    override fun getAllPlayersFromDb(): List<Player> {
        return playersRepository.getAllPlayersFromDb().map { mapper.playerDtoToInput(it) }
    }

    override fun getPlayerRankFromApiBySummonerName(summonerName: String): Either<LolRanksAppError, SummonerProjection> {
        val summonerRankInfo = riotClient.getPlayerRankFromApiBySummonerName(summonerName)
        return summonerRankInfo.mapLeft { error ->
                RiotFeignClientErrorMapper.mapError(error)
        }.map { mapper.summonerDtoToProjection(it) }
    }
}