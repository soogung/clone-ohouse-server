package com.soogung.ohouse.domain.cart.presentation

import com.soogung.ohouse.domain.cart.presentation.dto.request.PutProductRequest
import com.soogung.ohouse.domain.cart.service.PopDetailProductService
import com.soogung.ohouse.domain.cart.service.PopProductService
import com.soogung.ohouse.domain.cart.service.PutProductService
import com.soogung.ohouse.domain.cart.service.QueryCartService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/cart")
class CartController(
    private val queryCartService: QueryCartService,
    private val putProductService: PutProductService,
    private val popDetailProductService: PopDetailProductService,
    private val popProductService: PopProductService,
) {

    @PostMapping
    fun putProduct(@RequestBody @Valid request: PutProductRequest) {
        putProductService.execute(request)
    }

    @DeleteMapping
    fun popProduct(@RequestParam id: Long) {
        popProductService.execute(id)
    }

    @DeleteMapping("/detail")
    fun popDetailProduct(@RequestParam id: Long) {
        popDetailProductService.execute(id)
    }
}