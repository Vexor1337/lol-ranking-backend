package com.porek.lol.ranking.interfaces

import com.porek.lol.ranking.interfaces.web.ErrorResponseWrapper
import com.porek.lol.ranking.interfaces.web.toErrorResponse
import com.porek.lol.ranking.ports.input.*
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

class LolRanksEitherException(
    val eitherError: LolRanksError, val status: HttpStatus = HttpStatus.BAD_REQUEST
) : RuntimeException()

fun LolRanksError.toException(status: HttpStatus = HttpStatus.BAD_REQUEST) =
    LolRanksEitherException(eitherError = this, status = status)

@RestControllerAdvice(
    basePackages = ["com.porek.lol.ranking.interfaces"]
)
@Order(100)
class LolRanksControllerExceptionHandler {
    private val logger = LoggerFactory.getLogger(LolRanksControllerExceptionHandler::class.java)

    @ExceptionHandler(LolRanksEitherException::class)
    fun handleRuntimeException(exeption: LolRanksEitherException): ResponseEntity<ErrorResponseWrapper> =
        when (val e = exeption.eitherError) {
            is RiotApiUnauthorizedException -> e.message.toErrorResponse(HttpStatus.UNAUTHORIZED)
            is RiotApiServiceUnavailable -> e.message.toErrorResponse(HttpStatus.SERVICE_UNAVAILABLE)
            is RiotApiForbiddenException -> e.message.toErrorResponse(HttpStatus.FORBIDDEN)
            is SummonerNameNotFoundInRiotApi -> e.message.toErrorResponse(HttpStatus.NOT_FOUND)
            is LolRanksAppGenericError -> {
                e.message.toErrorResponse(HttpStatus.BAD_REQUEST, e.stackTrace)
            }
        }

    @ExceptionHandler(LolRanksGenericError::class)
    fun handleGenericError(exception: LolRanksGenericError): ResponseEntity<ErrorResponseWrapper> =
        exception.log().message.toErrorResponse(HttpStatus.BAD_REQUEST)

    private fun <T : RuntimeException> T.log(): T =
        apply { logger.warn(this.message + " " + this.stackTraceToString()) }
}