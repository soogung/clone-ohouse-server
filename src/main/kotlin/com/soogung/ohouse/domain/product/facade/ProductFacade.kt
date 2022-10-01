package com.soogung.ohouse.domain.product.facade

import com.soogung.ohouse.domain.product.domain.DetailProduct
import com.soogung.ohouse.domain.product.domain.Product
import com.soogung.ohouse.domain.product.domain.repository.DetailProductRepository
import com.soogung.ohouse.domain.product.domain.repository.ProductRepository
import com.soogung.ohouse.domain.product.exception.ProductNotFoundException
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ProductFacade(
    private val productRepository: ProductRepository,
    private val detailProductRepository: DetailProductRepository,
) {

    @Transactional(readOnly = true)
    fun findProductById(id: Long): Product {
        return productRepository.findProductById(id)
            ?: throw ProductNotFoundException.EXCEPTION
    }

    @Transactional(readOnly = true)
    fun findDetailProductById(id: Long): DetailProduct {
        return detailProductRepository.findDetailProductById(id)
            ?: throw ProductNotFoundException.EXCEPTION
    }
}