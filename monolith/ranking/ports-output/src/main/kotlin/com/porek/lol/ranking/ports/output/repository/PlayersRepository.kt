package com.porek.lol.ranking.ports.output.repository

import com.porek.lol.ranking.ports.output.persistance.PlayerDto
import org.springframework.stereotype.Repository

@Repository
interface PlayersRepository {
    fun getAllPlayersFromDb(): List<PlayerDto>
}