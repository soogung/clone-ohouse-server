package com.soogung.ohouse.domain.product.presentation

import com.soogung.ohouse.domain.product.presentation.dto.request.CreateProductRequest
import com.soogung.ohouse.domain.product.service.CreateProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/product")
class ProductController(
    private val createProductService: CreateProductService,
) {
    @PostMapping
    fun createProduct(@RequestBody @Valid request: CreateProductRequest) {
        createProductService.execute(request)
    }
}