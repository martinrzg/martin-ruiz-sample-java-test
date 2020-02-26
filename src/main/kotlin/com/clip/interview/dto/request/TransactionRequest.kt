package com.clip.interview.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import io.swagger.annotations.ApiModelProperty
import java.util.Date

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class TransactionRequest(
        @ApiModelProperty(example = "123", required = true, position = 0)
        var userId: Long,
        @ApiModelProperty(example = "5000", required = true, position = 1)
        var amount: Double,
        @ApiModelProperty(example = "Lorem ipsum description", required = true, position = 2)
        var description: String,
        @ApiModelProperty(example = "2019-02-23 10:20:30", required = true, position = 3)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        var createdAt: Date
)