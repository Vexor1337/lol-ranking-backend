package com.porek.lol.ranking.ports.input

data class Player(
    val playerId: Long,
    val name: String,
    val highestRank: String,
    val highestRankDate: String, //todo zmienić na LocalDateTime
    val currentElo: Long,
    val highestElo: Long
)
