package com.porek.lol.config

import feign.RequestInterceptor
import feign.RequestTemplate

class FeignClientInterceptor(private val riotApiToken: String) : RequestInterceptor {
    override fun apply(requestTemplate: RequestTemplate) {
        requestTemplate.header("X-Riot-Token", riotApiToken)
        requestTemplate.header("Content-Type", "application/json")
    }
}