package com.porek.lol.ranking.ports.output.persistance

data class RankDictDto(
    val rankId: Long,
    val rankName: RankName,
    val division: String,
    val elo: Long
)

enum class RankName {
    IRON,
    BRONZE,
    SILVER,
    GOLD,
    PLATINIUM,
    DIAMOND,
    MASTER,
    GRANDMASTER,
    CHALLANGER,
    UNKNOWN,
    UNRANKED
}