package com.porek.lol.ranking.infrastructure.persistance.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "players_ranks", schema = "ranking")
class PlayerRankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = -1

    @Column(name = "lp")
    var lp: Long? = null

    @Column(name = "last_check_date")
    var lastCheckDate: LocalDateTime? = null

    @Column(name = "rank_id")
    var rankId: Long = -1

    @Column(name = "player_id")
    var playerId: Long = -1

}