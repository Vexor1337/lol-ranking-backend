package com.porek.lol.ranking.application.mapper

import com.porek.lol.ranking.ports.input.Player
import com.porek.lol.ranking.ports.output.persistance.PlayerDto
import org.mapstruct.Mapper

@Mapper
interface PlayerMapper {
    fun playerDtoToInput(playerDto: PlayerDto): Player
}