package com.porek.lol.ranking.infrastructure.persistance.entity

import jakarta.persistence.*

@Entity
@Table(name = "rank_dict", schema ="ranking")
class RankDictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rank_id")
    var rankId: Long = -1

    @Enumerated(EnumType.STRING)
    @Column(name = "rank_name")
    var rankName: RankName? = null

    @Column(name = "division")
    var division: Long? = null

    @Column(name = "elo")
    var elo: Long = -1

}