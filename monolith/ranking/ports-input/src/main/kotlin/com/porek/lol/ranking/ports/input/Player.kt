package com.porek.lol.ranking.ports.input

data class Player(
    val playerName: String,
    val currentRank: String,
    val highestRank: String
)
