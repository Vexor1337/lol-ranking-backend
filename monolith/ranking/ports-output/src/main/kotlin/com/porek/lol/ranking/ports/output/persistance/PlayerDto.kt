package com.porek.lol.ranking.ports.output.persistance

data class PlayerDto(
    val playerName: String,
    val currentRank: String,
    val highestRank: String
)
