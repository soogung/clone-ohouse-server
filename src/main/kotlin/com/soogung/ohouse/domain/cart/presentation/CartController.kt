package com.soogung.ohouse.domain.cart.presentation

import com.soogung.ohouse.domain.cart.presentation.dto.request.PutProductRequest
import com.soogung.ohouse.domain.cart.service.PutProductService
import com.soogung.ohouse.domain.cart.service.QueryCartService
import com.soogung.ohouse.domain.cart.service.UpdateQuantityService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/cart")
class CartController(
    private val queryCartService: QueryCartService,
    private val putProductService: PutProductService,
    private val updateQuantityService: UpdateQuantityService,
) {

    @PostMapping
    fun putProduct(@RequestBody @Valid request: PutProductRequest) {
        putProductService.execute(request)
    }
}