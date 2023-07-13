package com.porek.lol.ranking.ports.input.service

import com.porek.lol.ranking.ports.input.Player
import com.porek.lol.ranking.ports.input.SummonerProjection
import org.springframework.stereotype.Service

@Service
interface RankingService {
    fun getAllPlayersFromDb(): List<Player>
    fun getPlayerRankFromApiBySummonerName(summonerName: String) : SummonerProjection
}