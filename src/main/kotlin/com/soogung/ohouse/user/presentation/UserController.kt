package com.soogung.ohouse.user.presentation

import com.soogung.ohouse.user.presentation.dto.request.JoinUserRequest
import com.soogung.ohouse.user.service.JoinService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val joinService: JoinService,
) {

    @PostMapping
    fun joinUser(@RequestBody request: JoinUserRequest) {
        joinService.execute(request)
    }
}