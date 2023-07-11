package com.porek.lol.ranking.infrastructure.facade

import com.porek.lol.ranking.infrastructure.adapter.PlayersAdapter
import com.porek.lol.ranking.infrastructure.mapper.PlayerMapper
import com.porek.lol.ranking.ports.output.persistance.PlayerDto
import com.porek.lol.ranking.ports.output.repository.PlayersRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Repository

@Repository
class PlayersRepositoryFacade(private val playersAdapter: PlayersAdapter): PlayersRepository {
    private val playerMapper = Mappers.getMapper(PlayerMapper::class.java)


    override fun getAllPlayersFromDb(): List<PlayerDto> {
        return playersAdapter.getAllPlayers().map { playerMapper.entityToDto(it) }
    }

}