package io.dori.api.controller.controller.advice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class DefaultExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun unknownExceptionHandle(e: Exception): ResponseEntity<String> =
        ResponseEntity.internalServerError().body("Unknown Error. message=${e.message}")
}