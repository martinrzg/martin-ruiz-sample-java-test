package com.clip.interview.model.repository

import com.clip.interview.model.entity.TransactionEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface TransactionRepository : JpaRepository<TransactionEntity, UUID> {
    fun findFirstByIdAndUserId(id: UUID, userId: Long): TransactionEntity?
    fun findByUserIdOrderByCreatedAtAsc(userId: Long): List<TransactionEntity>
    fun findAllByUserId(userId: Long): List<TransactionEntity>

    //TODO change to code
    @Query(value = "SELECT SUM(t.amount) FROM TransactionEntity t WHERE t.userId = :userId")
    fun sumAllUserTransactions(userId: Long): Double?

    @Query(value = "SELECT t FROM TransactionEntity t order by function('RAND')")
    fun findRandom(pageable: Pageable): List<TransactionEntity>
}