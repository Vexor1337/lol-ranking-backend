package com.porek.lol.ranking.infrastructure.persistance.entity

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "players", schema = "ranking")
class PlayerEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    var playerId: Long = -1,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "summoner_name")
    var summonerName: String? = null,

/*    @Column(name = "current_rank")
    var currentRank: String? = null*/

    @Column(name = "highest_rank")
    var highestRank: String? = null,

    @Column(name = "highest_rank_date")
    var highestRankDate: String? = null, //todo zmienić na LocalDateTime

    @Column(name = "current_elo")
    var currentElo: String? = null,

    @Column(name = "highest_elo")
    var highestElo: String? = null
)