package com.soogung.ohouse.domain.user.presentation

import com.soogung.ohouse.domain.user.presentation.dto.request.JoinUserRequest
import com.soogung.ohouse.domain.user.presentation.dto.request.LoginUserRequest
import com.soogung.ohouse.domain.user.presentation.dto.response.TokenResponse
import com.soogung.ohouse.domain.user.service.JoinService
import com.soogung.ohouse.domain.user.service.LoginService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val joinService: JoinService,
    private val loginService: LoginService,
) {

    @PostMapping
    fun joinUser(@RequestBody request: JoinUserRequest) {
        joinService.execute(request)
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody request: LoginUserRequest): TokenResponse {
        return loginService.execute(request)
    }
}