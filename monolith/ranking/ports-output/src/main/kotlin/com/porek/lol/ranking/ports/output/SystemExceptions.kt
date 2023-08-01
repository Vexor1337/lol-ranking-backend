package com.porek.lol.ranking.ports.output

import EitherError

sealed interface RiotFeignClientError: EitherError

    class RiotFeignClientGenericError(override val message: String, val stackTrace: List<String>?): RiotFeignClientError

    class RiotFeignClientUnauthorizedException() : RiotFeignClientError{
        override val message: String
            get() = "No Riot API key passed"
    }
    class RiotFeignClientServiceUnavailable() : RiotFeignClientError{
        override val message: String
            get() = "Riot Service Unavailable"
    }
class RiotFeignClientForbiddenException() : RiotFeignClientError{
    override val message: String
        get() = "Invalid Riot api key"
}
class SummonerNameNotFoundInRiotApi(val summonerName: String) : RiotFeignClientError{
    override val message: String
        get() = "Summoner name $summonerName not found in Riot Api"
}
