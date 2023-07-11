package com.porek.lol.ranking.infrastructure.persistance.entity

import jakarta.persistence.*


@Entity
@Table(name = "player", schema = "ranking")
class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = -1

    @Column(name = "player_name")
    var playerName: String? = null

    @Column(name = "current_rank")
    var currentRank: String? = null

    @Column(name = "highest_rank")
    var highestRank: String? = null
}