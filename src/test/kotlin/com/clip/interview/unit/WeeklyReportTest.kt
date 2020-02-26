package com.clip.interview.unit

import com.clip.interview.dto.response.ReportResponse
import com.clip.interview.enums.ReportTypes
import com.clip.interview.model.entity.TransactionEntity
import com.clip.interview.service.TransactionService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class WeeklyReportTest {

    @Autowired
    private lateinit var transactionService: TransactionService

    @Test
    fun get_weekly_report_with_empty_list_should_return_empty_list() {
        val transactions = emptyList<TransactionEntity>()
        Assertions.assertEquals(emptyList<ReportResponse>(), transactionService.getWeeklyReport(transactions))
    }


}