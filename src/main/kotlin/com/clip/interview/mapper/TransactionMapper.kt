package com.clip.interview.mapper

import com.clip.interview.dto.request.TransactionRequest
import com.clip.interview.dto.response.TransactionResponse
import com.clip.interview.model.entity.TransactionEntity

object TransactionMapper {

    fun requestToEntity(transactionRequest: TransactionRequest): TransactionEntity {
        return TransactionEntity(
                userId = transactionRequest.userId,
                amount = transactionRequest.amount,
                description = transactionRequest.description,
                createdAt = transactionRequest.createdAt
        )
    }

    fun entityToResponse(entity: TransactionEntity): TransactionResponse {
        return TransactionResponse(
                transactionId = entity.id,
                userId = entity.userId,
                amount = entity.amount,
                description = entity.description,
                createdAt = entity.createdAt
        )
    }
}