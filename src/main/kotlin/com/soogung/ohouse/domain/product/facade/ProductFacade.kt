package com.soogung.ohouse.domain.product.facade

import com.soogung.ohouse.domain.product.domain.Product
import com.soogung.ohouse.domain.product.domain.repository.ProductRepository
import com.soogung.ohouse.domain.product.exception.ProductNotFoundException
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ProductFacade(
    private val productRepository: ProductRepository,
) {

    @Transactional(readOnly = true)
    fun findProductById(id: Long):Product {
        return productRepository.findProductById(id)
            ?: throw ProductNotFoundException.EXCEPTION
    }
}