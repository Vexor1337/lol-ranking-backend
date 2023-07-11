package com.porek.lol.ranking.application

import com.porek.lol.ranking.application.mapper.PlayerMapper
import com.porek.lol.ranking.ports.input.Player
import com.porek.lol.ranking.ports.input.service.RankingService
import com.porek.lol.ranking.ports.output.repository.PlayersRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service

@Service
class RankingServiceImpl(private val playersRepository: PlayersRepository) : RankingService {
    private val playerMapper = Mappers.getMapper(PlayerMapper::class.java)
    override fun getAllPlayersFromDb(): List<Player> {
        return playersRepository.getAllPlayersFromDb().map { playerMapper.playerDtoToInput(it) }
    }
}