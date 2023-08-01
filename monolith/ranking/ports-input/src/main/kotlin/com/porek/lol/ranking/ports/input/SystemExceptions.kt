package com.porek.lol.ranking.ports.input

import EitherError

sealed interface LolRanksError : EitherError

sealed interface LolRanksAppError: LolRanksError

class LolRanksGenericError(override val message: String): RuntimeException(message)

class RiotApiUnauthorizedException(override val message: String) : LolRanksAppError

class RiotApiServiceUnavailable(override val message: String) : LolRanksAppError

class RiotApiForbiddenException(override val message: String) : LolRanksAppError

class SummonerNameNotFoundInRiotApi(override val message: String) : LolRanksAppError

class LolRanksAppGenericError(override val message: String, val stackTrace: List<String>?): LolRanksAppError
