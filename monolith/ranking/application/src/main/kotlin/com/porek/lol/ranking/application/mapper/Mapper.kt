package com.porek.lol.ranking.application.mapper

import com.porek.lol.ranking.ports.input.Player
import com.porek.lol.ranking.ports.input.SummonerProjection
import com.porek.lol.ranking.ports.output.persistance.PlayerDto
import com.porek.lol.ranking.ports.output.persistance.SummonerDto
import org.mapstruct.Mapper

@Mapper
interface Mapper {
    fun playerDtoToInput(playerDto: PlayerDto): Player
    fun summonerDtoToProjection(summonerDto: SummonerDto): SummonerProjection
}