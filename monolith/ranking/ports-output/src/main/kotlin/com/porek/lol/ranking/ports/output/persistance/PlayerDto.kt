package com.porek.lol.ranking.ports.output.persistance

import java.time.LocalDateTime

data class PlayerDto(
    val playerId: Long,
    val name: String,
    val highestRank: String,
    val highestRankDate: String, //todo zmienic na LocalDateTime
    val currentElo: Long,
    val highestElo: Long
)

