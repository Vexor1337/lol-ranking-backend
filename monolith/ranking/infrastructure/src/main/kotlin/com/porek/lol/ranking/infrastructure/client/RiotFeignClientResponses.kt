package com.porek.lol.ranking.infrastructure.client

import java.time.LocalDateTime

data class GetEncryptedSummonerNameResponse(
    val id: String,
    val accountId: String,
    val ppuid: String,
    val name: String,
    val profileIconId: Int,
    val revisionDate: Long,
    val summonerLvl: Int,
)

data class GetSummonerRankInfo(
    val leagueId: String,
    val queueType: String,
    val tier: String,
    val rank: String,
    val summonerId: String,
    val summonerName: String,
    val leaguePoints: Int,
    val wins: Int,
    val losses: Int,
    val veteran: Boolean,
    val inactive: Boolean,
    val freshBlood: Boolean,
    val hotStreak: Boolean,
)