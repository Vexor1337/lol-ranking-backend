package com.porek.lol.ranking.application.mapper

import com.porek.lol.ranking.ports.input.LolRanksAppError
import com.porek.lol.ranking.ports.output.*

interface ErrorMapper<E, out T> {
    fun mapError(error: E): T
}

object RiotFeignClientErrorMapper : ErrorMapper<RiotFeignClientError, LolRanksAppError> {
    override fun mapError(error: RiotFeignClientError): LolRanksAppError {
        return when (error) {
            is RiotFeignClientServiceUnavailable -> com.porek.lol.ranking.ports.input.RiotApiServiceUnavailable(error.message)
            is RiotFeignClientForbiddenException -> com.porek.lol.ranking.ports.input.RiotApiForbiddenException(error.message)
            is RiotFeignClientUnauthorizedException -> com.porek.lol.ranking.ports.input.RiotApiUnauthorizedException(error.message)
            is SummonerNameNotFoundInRiotApi -> com.porek.lol.ranking.ports.input.SummonerNameNotFoundInRiotApi(error.message)
            is RiotFeignClientGenericError -> com.porek.lol.ranking.ports.input.LolRanksAppGenericError(error.message, error.stackTrace)
        }
    }
}