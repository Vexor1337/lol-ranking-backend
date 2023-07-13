package com.porek.lol.config

import com.porek.lol.ranking.infrastructure.client.RiotFeignClient
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RiotFeignClientConfig {
    @Bean
    fun createLolRankingFeignClient(@Value("\${riot.api.url}") url: String): RiotFeignClient {
        return Feign.builder()
            .decoder(GsonDecoder())
            .encoder(GsonEncoder())
            .target(RiotFeignClient::class.java, url)
    }
}