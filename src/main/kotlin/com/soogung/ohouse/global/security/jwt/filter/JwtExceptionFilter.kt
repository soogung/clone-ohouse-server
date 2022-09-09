package com.soogung.ohouse.global.security.jwt.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.soogung.ohouse.global.error.ErrorResponse
import com.soogung.ohouse.global.error.exception.OhouseException
import org.springframework.http.HttpStatus
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtExceptionFilter(
    private val mapper: ObjectMapper
): OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(req: HttpServletRequest, res: HttpServletResponse, chain: FilterChain) {
        try {
            chain.doFilter(req, res) // go to 'JwtAuthenticationFilter'
        } catch (e: OhouseException) {
            setErrorResponse(res, e)
        }
    }

    @Throws(IOException::class)
    fun setErrorResponse(res: HttpServletResponse, e: OhouseException) {
        res.status = HttpStatus.UNAUTHORIZED.value()
        res.contentType = "application/json; charset=UTF-8"
        val errorResponse: ErrorResponse = ErrorResponse(
            status = e.errorCode.status,
            message = e.errorCode.message
        )
        res.writer.write(mapper.writeValueAsString(errorResponse))
    }
}