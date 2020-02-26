package com.clip.interview.service

import com.clip.interview.dto.request.TransactionRequest
import com.clip.interview.dto.response.ReportResponse
import com.clip.interview.dto.response.SumTransactionsResponse
import com.clip.interview.dto.response.TransactionResponse
import com.clip.interview.enums.ReportTypes
import com.clip.interview.mapper.TransactionMapper
import com.clip.interview.model.entity.TransactionEntity
import com.clip.interview.utils.nextValidWeekEnd
import com.clip.interview.utils.previousValidWeekStart
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Calendar
import java.util.Date
import java.util.UUID

@Service
class TransactionService {

    @Autowired
    private lateinit var transactionRepositoryService: TransactionRepositoryService

    fun createTransaction(request: TransactionRequest): TransactionResponse {
        val transactionEntity = transactionRepositoryService.saveTransaction(
                TransactionMapper.requestToEntity(request)
        )
        return TransactionMapper.entityToResponse(transactionEntity)
    }

    fun getByIdAndUserId(id: UUID, userId: Long): TransactionResponse {
        return TransactionMapper.entityToResponse(transactionRepositoryService.findByIdAndUserId(id, userId))
    }

    fun getAllFromUser(userId: Long): MutableList<TransactionResponse> {
        val transactions = mutableListOf<TransactionResponse>()
        transactionRepositoryService.findByUserIdOrderByCreatedAtAsc(userId).forEach { entity ->
            transactions.add(TransactionMapper.entityToResponse(entity))
        }
        return transactions
    }

    fun sumAllUserTransactions(userId: Long): SumTransactionsResponse {
        val sum = transactionRepositoryService.sumAllUserTransactions(userId)
        return SumTransactionsResponse(userId, sum)
    }

    fun sumAllTransactionsNoDb(userId: Long): SumTransactionsResponse {
        var sum = 0.0
        transactionRepositoryService.findAllByUserId(userId).forEach {
            sum += it.amount
        }
        return SumTransactionsResponse(userId, sum)
    }

    fun getRandom(): TransactionResponse {
        return TransactionMapper.entityToResponse(transactionRepositoryService.findRandom())
    }

    fun getReportData(type: ReportTypes, userId: Long): List<ReportResponse> {
        val transactions = transactionRepositoryService.findByUserIdOrderByCreatedAtAsc(userId)
        return when (type) {
            ReportTypes.WEEKLY -> getWeeklyReport(transactions)
        }
    }

    fun getWeeklyReport(transactions: List<TransactionEntity>): List<ReportResponse> {
        val reportResponse = mutableListOf<ReportResponse>()
        var currentStartDay: Date? = null
        var totalAmount = 0.0

        transactions.forEach { transaction ->
            val startDate = transaction.createdAt.previousValidWeekStart(Calendar.FRIDAY)
            val endDate = transaction.createdAt.nextValidWeekEnd(Calendar.THURSDAY)

            if (currentStartDay != startDate) {
                if (reportResponse.isNotEmpty()) totalAmount += reportResponse.last().amount
                reportResponse.add(
                        ReportResponse(
                                transaction.userId,
                                startDate,
                                endDate,
                                1,
                                transaction.amount,
                                totalAmount = totalAmount
                        )
                )
            } else {
                reportResponse.last().apply {
                    quantity++
                    amount += transaction.amount
                }
            }
            currentStartDay = startDate
        }
        return reportResponse
    }

}