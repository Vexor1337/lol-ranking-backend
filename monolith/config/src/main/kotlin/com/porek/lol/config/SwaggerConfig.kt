package com.porek.lol.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenApiConfig {
    @Bean
    fun usersMicroserviceOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info().title("Ranking API")
                    .description("API for Ranking")
                    .version("1.0")
            )
    }
}
