package com.clip.interview.service

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class TransactionRepositoryServiceTest {

    companion object {
        @BeforeEach
        @Sql(scripts = ["/queries/insert_trasactions_test_data1.sql"])
        fun loadTestData() {

        }
    }

    @Test
    fun saveTransaction() {

    }

//    @Test
//    fun findByIdAndUserId() {
//    }
//
//    @Test
//    fun findByUserIdOrderByCreatedAtAsc() {
//    }
//
//    @Test
//    fun sumAllUserTransactions() {
//    }
//
//    @Test
//    fun findAllByUserId() {
//    }
//
//    @Test
//    fun findRandom() {
//    }
}