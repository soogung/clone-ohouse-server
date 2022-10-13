package com.soogung.ohouse.domain.product.service

import com.soogung.ohouse.domain.product.domain.Product
import com.soogung.ohouse.domain.product.domain.repository.DetailProductRepository
import com.soogung.ohouse.domain.product.domain.repository.ProductRepository
import com.soogung.ohouse.domain.product.facade.ProductFacade
import com.soogung.ohouse.domain.product.presentation.dto.response.ProductDetailResponse
import com.soogung.ohouse.domain.product.presentation.dto.response.ProductImageResponse
import com.soogung.ohouse.domain.product.presentation.dto.response.ProductListResponse
import com.soogung.ohouse.domain.product.presentation.dto.response.ProductResponse
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.math.roundToInt

@Service
class QueryProductService(
    private val productRepository: ProductRepository,
    private val detailProductRepository: DetailProductRepository,
) {

    @Transactional(readOnly = true)
    fun execute(pageable: Pageable): ProductListResponse {
        return ProductListResponse.of(
            productRepository.findRandomProducts(pageable).map(this::createProductResponse)
        )
    }

    private fun createProductResponse(product: Product): ProductResponse {
        val price = detailProductRepository.findMinPriceByProduct(product)

        return ProductResponse(
            id = product.id!!,
            name = product.name,
            company = product.company,
            isDiscount = product.isDiscount,
            discountDegree = product.discountDegree?.times(100)!!.roundToInt(),
            mainImage = ProductImageResponse.of(product.images[0]),
            price = price,
            discountedPrice = product.discountDegree?.times(price)!!.roundToInt()
        )
    }
}