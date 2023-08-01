package com.porek.lol.ranking.ports.input.service

import arrow.core.Either
import com.porek.lol.ranking.ports.input.Player
import com.porek.lol.ranking.ports.input.LolRanksAppError
import com.porek.lol.ranking.ports.input.SummonerProjection
import org.springframework.stereotype.Service

@Service
interface RankingService {
    fun getAllPlayersFromDb(): List<Player>
    fun getPlayerRankFromApiBySummonerName(summonerName: String) : Either<LolRanksAppError, SummonerProjection>
}