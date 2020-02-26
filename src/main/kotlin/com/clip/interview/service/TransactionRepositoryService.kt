package com.clip.interview.service

import com.clip.interview.model.entity.TransactionEntity
import com.clip.interview.model.repository.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.UUID
import javax.persistence.EntityNotFoundException

@Service
class TransactionRepositoryService {

    @Autowired
    private lateinit var transactionRepository: TransactionRepository

    fun saveTransaction(entity: TransactionEntity): TransactionEntity {
        return transactionRepository.save(entity)
    }

    fun findByIdAndUserId(id: UUID, userId: Long): TransactionEntity {
        return transactionRepository.findFirstByIdAndUserId(id, userId) ?: let {
            throw EntityNotFoundException("Unable to find transaction for id: [$id], userId: [$userId]")
        }
    }

    fun findByUserIdOrderByCreatedAtAsc(userId: Long): List<TransactionEntity> {
        return transactionRepository.findByUserIdOrderByCreatedAtAsc(userId)
    }

    fun sumAllUserTransactions(userId: Long): Double {
        return transactionRepository.sumAllUserTransactions(userId) ?: let {
            throw EntityNotFoundException("Unable to find transactions for userId: [$userId]")
        }
    }

    fun findAllByUserId(userId: Long): List<TransactionEntity> {
        return transactionRepository.findAllByUserId(userId)
    }

    fun findRandom(): TransactionEntity {
        return transactionRepository.findRandom(PageRequest.of(0, 1)).first()
    }
}