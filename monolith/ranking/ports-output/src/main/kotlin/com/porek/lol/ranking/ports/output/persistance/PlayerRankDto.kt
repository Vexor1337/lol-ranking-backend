package com.porek.lol.ranking.ports.output.persistance

import java.time.LocalDateTime

data class PlayerRankDto(
    val id: Long,
    val lp: Long,
    val lastCheckDate: LocalDateTime,
    val rankId: Long,
    val playerId: Long
)

