package com.porek.lol.ranking.interfaces.web

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

typealias Response<T> = ResponseEntity<ResponseWrapper<T>>

class ResponseWrapper<T>(val data: T) {
    companion object{
        fun<T> of(data: T): ResponseWrapper<T>{
            return ResponseWrapper(data)
        }
    }
}

fun <T> response(result: T, status:HttpStatus) =
    ResponseEntity(ResponseWrapper(result), status)

fun <T> T.toResponse(status: HttpStatus = HttpStatus.OK): Response<T> =
    ResponseEntity(ResponseWrapper(this), status)
