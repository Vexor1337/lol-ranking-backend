package com.porek.lol.ranking.infrastructure.adapter

import com.porek.lol.ranking.infrastructure.persistance.repository.PlayerRankRepository
import org.springframework.stereotype.Repository

@Repository
class PlayerRankAdapter(private val playerRankRepository: PlayerRankRepository) {
}