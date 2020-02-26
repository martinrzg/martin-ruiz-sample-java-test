package com.clip.interview.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.Date

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class ReportResponse(
        val userId: Long,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd EEEE")
        val weekStartDate: Date,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd EEEE")
        val weekFinishDate: Date,
        var quantity: Int,
        var amount: Double,
        var totalAmount: Double
)