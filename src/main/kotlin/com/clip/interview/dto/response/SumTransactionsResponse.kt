package com.clip.interview.dto.response

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class SumTransactionsResponse(
        val userId: Long,
        val sum: Double
)