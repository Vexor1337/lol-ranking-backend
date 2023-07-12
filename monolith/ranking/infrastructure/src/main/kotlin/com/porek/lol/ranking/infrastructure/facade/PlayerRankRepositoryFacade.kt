package com.porek.lol.ranking.infrastructure.facade

import com.porek.lol.ranking.infrastructure.adapter.PlayerRankAdapter
import org.springframework.stereotype.Repository

@Repository
class PlayerRankRepositoryFacade(private val playerRankAdapter: PlayerRankAdapter) {
}