package com.porek.lol.ranking.application

import arrow.core.getOrElse
import com.porek.lol.ranking.application.mapper.Mapper
import com.porek.lol.ranking.ports.input.Player
import com.porek.lol.ranking.ports.input.SummonerProjection
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

    override fun getPlayerRankFromApiBySummonerName(summonerName: String): SummonerProjection {
        val summonerRankInfo = riotClient.getPlayerRankFromApiBySummonerName(summonerName).getOrElse { error("xdddd") }
        return mapper.summonerDtoToProjection(summonerRankInfo)
    }
}