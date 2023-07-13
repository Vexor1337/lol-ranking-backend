package com.porek.lol.ranking.infrastructure.mapper

import com.porek.lol.ranking.infrastructure.client.GetSummonerRankInfo
import com.porek.lol.ranking.infrastructure.persistance.entity.PlayerEntity
import com.porek.lol.ranking.ports.output.persistance.PlayerDto
import com.porek.lol.ranking.ports.output.persistance.SummonerDto
import org.mapstruct.Mapper

@Mapper
interface PlayerMapper {
    fun entityToDto(playerEntity: PlayerEntity) : PlayerDto
}

fun GetSummonerRankInfo.toSummonerDto() = SummonerDto(
    summonerName = this.summonerName,
    rank = this.tier + " " +  this.rank + " lp " + this.leaguePoints
)