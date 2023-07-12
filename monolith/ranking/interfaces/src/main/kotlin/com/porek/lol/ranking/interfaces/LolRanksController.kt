package com.porek.lol.ranking.interfaces

import com.porek.lol.ranking.interfaces.web.Response
import com.porek.lol.ranking.interfaces.web.toResponse
import com.porek.lol.ranking.ports.input.Player
import com.porek.lol.ranking.ports.input.service.RankingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ranking")
class LolRanksController(private val rankingService: RankingService) {

    @GetMapping("/getAllPlayersFromDb/")
    fun getAllPlayersFromDb(): Response<List<Player>>{
        return rankingService.getAllPlayersFromDb().toResponse()
    }
}