package com.porek.lol.ranking.interfaces.web

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ErrorResponseWrapper(
    val status: Int,
    val error: String,
    val message: String?,
    val stackTrace: List<String>? = null
){
    companion object {
        fun of(status: HttpStatus, message: String?): ErrorResponseWrapper{
            return ErrorResponseWrapper(status.value(), status.reasonPhrase, message)
        }
    }
}

fun String.toErrorResponse(status: HttpStatus, stackTrace: List<String>? = null): ResponseEntity<ErrorResponseWrapper> =
    ResponseEntity(
        ErrorResponseWrapper(
            status = status.value(),
            error = status.reasonPhrase,
            message = this,
            stackTrace = stackTrace
        ),
        status
    )