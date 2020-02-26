package com.clip.interview.handler

import com.clip.interview.dto.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.persistence.EntityNotFoundException

@RestControllerAdvice
class FeignExceptionHandler {

    @ExceptionHandler(value = [EntityNotFoundException::class])
    fun handleResponseException(ex: EntityNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(HttpStatus.NOT_FOUND.reasonPhrase, ex.message), HttpStatus.NOT_FOUND)
    }
}