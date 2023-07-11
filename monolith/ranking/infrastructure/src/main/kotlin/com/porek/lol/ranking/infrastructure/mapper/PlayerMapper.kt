package com.porek.lol.ranking.infrastructure.mapper

import com.porek.lol.ranking.infrastructure.persistance.entity.PlayerEntity
import com.porek.lol.ranking.ports.output.persistance.PlayerDto
import org.mapstruct.Mapper

@Mapper
interface PlayerMapper {
    fun entityToDto(playerEntity: PlayerEntity) : PlayerDto
}