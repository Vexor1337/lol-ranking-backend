package com.porek.lol.ranking.infrastructure.client

import feign.Param
import feign.RequestLine

interface RiotFeignClient {

    @RequestLine("GET lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
    fun getSummonerRankInfo(@Param encryptedSummonerId: String) : List<GetSummonerRankInfo>

    @RequestLine("GET lol/summoner/v4/summoners/by-name/{summonerName}")
    fun getEncryptedSummonerName(@Param summonerName: String): GetEncryptedSummonerNameResponse

}