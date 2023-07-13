package com.porek.lol.ranking.infrastructure.client

import feign.Headers
import feign.Param
import feign.RequestLine
import org.springframework.stereotype.Repository

interface RiotFeignClient {

    @Headers("X-Riot-Token: \${riot.api.url}")
    @RequestLine("GET lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
    fun getSummonerRankInfo(@Param encryptedSummonerId: String) : List<GetSummonerRankInfo>

    @Headers(value = [
        "X-Riot-Token: \${riot.api.token}",
        "Content-Type: application/json",
    ])
    @RequestLine("GET lol/summoner/v4/summoners/by-name/{summonerName}")
    fun getEncryptedSummonerName(@Param summonerName: String): GetEncryptedSummonerNameResponse

}