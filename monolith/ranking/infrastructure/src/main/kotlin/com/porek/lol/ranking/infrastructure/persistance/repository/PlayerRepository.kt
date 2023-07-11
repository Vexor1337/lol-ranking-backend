package com.porek.lol.ranking.infrastructure.persistance.repository

import com.porek.lol.ranking.infrastructure.persistance.entity.PlayerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : JpaRepository<PlayerEntity, Long> {

}