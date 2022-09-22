package com.soogung.ohouse.domain.product.presentation

import com.soogung.ohouse.domain.product.presentation.dto.request.CreateProductRequest
import com.soogung.ohouse.domain.product.presentation.dto.response.ProductDetailResponse
import com.soogung.ohouse.domain.product.service.CreateProductService
import com.soogung.ohouse.domain.product.service.QueryProductDetailService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/product")
class ProductController(
    private val createProductService: CreateProductService,
    private val queryProductDetailService: QueryProductDetailService,
) {
    @PostMapping
    fun createProduct(@RequestBody @Valid request: CreateProductRequest) {
        createProductService.execute(request)
    }

    @GetMapping("/{id}")
    fun getProductDetail(@PathVariable id: Long): ProductDetailResponse {
        return queryProductDetailService.execute(id)
    }
}