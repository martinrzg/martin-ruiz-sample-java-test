package com.clip.interview.model.entity

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.Type
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
@Table(name = "transactions")
class TransactionEntity(
        @Id
        @Type(type = "pg-uuid")
        @Column(name = "transaction_id", unique = true, nullable = false)
        var id: UUID = UUID.randomUUID(),

        @Column(name = "user_id", nullable = false)
        var userId: Long,

        @Column(name = "amount", nullable = false, precision = 12, scale = 4)
        var amount: Double,

        @Column(name = "description")
        var description: String,

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "created_at", columnDefinition = "TIMESTAMP", updatable = false)
        var createdAt: Date = Date(),

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
        var updateAt: Date = Date()
)