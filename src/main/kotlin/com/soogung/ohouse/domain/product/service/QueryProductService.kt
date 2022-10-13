package com.soogung.ohouse.domain.product.service

import com.soogung.ohouse.domain.product.domain.repository.ProductRepository
import com.soogung.ohouse.domain.product.facade.ProductFacade
import com.soogung.ohouse.domain.product.presentation.dto.response.ProductDetailResponse
import com.soogung.ohouse.domain.product.presentation.dto.response.ProductListResponse
import com.soogung.ohouse.domain.product.presentation.dto.response.ProductResponse
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryProductService(
    private val productRepository: ProductRepository,
) {

    @Transactional(readOnly = true)
    fun execute(pageable: Pageable): ProductListResponse {
        return ProductListResponse.of(
            productRepository.findRandomProducts(pageable).map(ProductResponse::of)
        )
    }
}