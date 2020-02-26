package com.clip.interview.controller.v1

import com.clip.interview.dto.request.TransactionRequest
import com.clip.interview.dto.response.ReportResponse
import com.clip.interview.dto.response.SumTransactionsResponse
import com.clip.interview.dto.response.TransactionResponse
import com.clip.interview.enums.ReportTypes
import com.clip.interview.route.Route
import com.clip.interview.service.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(value = [Route.V1])
class TransactionController {

    @Autowired
    private lateinit var transactionService: TransactionService

    @PostMapping(value = [Route.Transaction.TRANSACTIONS], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createTransaction(@RequestBody transactionRequest: TransactionRequest): ResponseEntity<TransactionResponse> {
        return ResponseEntity(transactionService.createTransaction(transactionRequest), HttpStatus.CREATED)
    }

    @GetMapping(value = [Route.Transaction.GET_TRANSACTIONS], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTransaction(@PathVariable(value = "id") id: UUID, @RequestParam(value = "user_id") userId: Long): ResponseEntity<TransactionResponse> {
        return ResponseEntity(transactionService.getByIdAndUserId(id, userId), HttpStatus.OK)
    }

    @GetMapping(value = [Route.Transaction.TRANSACTIONS], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTransactions(@RequestParam(value = "user_id") userId: Long): ResponseEntity<List<TransactionResponse>> {
        return ResponseEntity(transactionService.getAllFromUser(userId), HttpStatus.OK)
    }

    @GetMapping(value = [Route.Transaction.SUM_TRANSACTIONS], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getSumAllUserTransactions(@RequestParam(value = "user_id") userId: Long): ResponseEntity<SumTransactionsResponse> {
        return ResponseEntity(transactionService.sumAllTransactionsNoDb(userId), HttpStatus.OK)
    }

    @GetMapping(value = [Route.Transaction.RANDOM_TRANSACTION], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getRandom(): ResponseEntity<TransactionResponse> {
        return ResponseEntity(transactionService.getRandom(), HttpStatus.OK)
    }

    @GetMapping(value = [Route.Transaction.REPORT], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getReportData(@RequestParam(value = "type") type: ReportTypes, @RequestParam(value = "user_id") userId: Long): ResponseEntity<List<ReportResponse>> {
        return ResponseEntity(transactionService.getReportData(type, userId), HttpStatus.OK)
    }
}