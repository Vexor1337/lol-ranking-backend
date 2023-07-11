package com.porek.lol.ranking.infrastructure.adapter

import com.porek.lol.ranking.infrastructure.persistance.entity.PlayerEntity
import com.porek.lol.ranking.infrastructure.persistance.repository.PlayerRepository
import org.springframework.stereotype.Repository

@Repository
class PlayersAdapter(private val playerRepository: PlayerRepository) {

    fun getAllPlayers(): List<PlayerEntity> = playerRepository.findAll()

}