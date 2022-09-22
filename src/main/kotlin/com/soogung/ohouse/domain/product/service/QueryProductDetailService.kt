package com.soogung.ohouse.domain.product.service

import com.soogung.ohouse.domain.product.facade.ProductFacade
import com.soogung.ohouse.domain.product.presentation.dto.response.ProductDetailResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryProductDetailService(
    private val productFacade: ProductFacade,
) {

    @Transactional(readOnly = true)
    fun execute(id: Long): ProductDetailResponse {
        val product = productFacade.findProductById(id)
        return ProductDetailResponse.of(product)
    }
}