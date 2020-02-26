package com.clip.interview.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.Date
import java.util.UUID

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class TransactionResponse(
        var transactionId: UUID,
        var userId: Long,
        var amount: Double,
        var description: String,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        var createdAt: Date
)