package com.porek.lol.ranking.ports.output.clients

import arrow.core.Either
import com.porek.lol.ranking.ports.output.RiotFeignClientError

import com.porek.lol.ranking.ports.output.persistance.SummonerDto
import org.springframework.stereotype.Repository

@Repository
interface RiotClient {
    fun getPlayerRankFromApiBySummonerName(summonerName: String) : Either<RiotFeignClientError, SummonerDto>
}