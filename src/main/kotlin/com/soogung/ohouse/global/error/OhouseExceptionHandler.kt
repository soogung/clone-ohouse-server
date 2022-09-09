package com.soogung.ohouse.global.error

import com.soogung.ohouse.global.error.exception.ErrorCode
import com.soogung.ohouse.global.error.exception.OhouseException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class OhouseExceptionHandler {

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(OhouseException::class)
    fun handleOhouseException(
        e: OhouseException,
        request: HttpServletRequest
    ): ErrorResponse {
        return ErrorResponse(e.errorCode);
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleBadRequest(
        e: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ErrorResponse {
        return ErrorResponse(
            status = ErrorCode.BAD_REQUEST.status,
            message = "${e.bindingResult.fieldErrors[0].field}의 ${e.bindingResult.fieldErrors[0].defaultMessage}"
        )
    }

    @ExceptionHandler(Exception::class)
    fun handleException(
        e: Exception,
        request: HttpServletRequest
    ): ErrorResponse {
        return ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR)
    }
}