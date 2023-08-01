package com.porek.lol.ranking.interfaces

import arrow.core.Either
import com.porek.lol.ranking.interfaces.web.Response
import com.porek.lol.ranking.interfaces.web.toResponse
import com.porek.lol.ranking.ports.input.Player
import com.porek.lol.ranking.ports.input.SummonerProjection
import com.porek.lol.ranking.ports.input.service.RankingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ranking")
class LolRanksController(private val rankingService: RankingService) {

    @GetMapping("/getAllPlayersFromDb/")
    fun getAllPlayersFromDb(): Response<List<Player>>{
        return rankingService.getAllPlayersFromDb().toResponse()
    }

    @GetMapping("/getPlayerRankFromApiBySummonerName/")
    fun getPlayerRankFromApiBySummonerName(@RequestParam summonerName: String) : Response<SummonerProjection>{
        return when(val result = rankingService.getPlayerRankFromApiBySummonerName(summonerName)){
            is Either.Right -> result.value.toResponse()
            is Either.Left -> throw result.value.toException()
        }
    }
}