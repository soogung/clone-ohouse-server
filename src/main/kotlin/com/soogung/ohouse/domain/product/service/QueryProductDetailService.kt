package com.soogung.ohouse.domain.product.service

import com.soogung.ohouse.domain.product.domain.Product
import com.soogung.ohouse.domain.product.domain.repository.DetailProductRepository
import com.soogung.ohouse.domain.product.facade.ProductFacade
import com.soogung.ohouse.domain.product.presentation.dto.response.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.math.roundToInt

@Service
class QueryProductDetailService(
    private val productFacade: ProductFacade,
    private val detailProductRepository: DetailProductRepository,
) {

    @Transactional(readOnly = true)
    fun execute(id: Long): ProductDetailResponse {
        val product = productFacade.findProductById(id)
        return createProductDetailResponse(product)
    }

    private fun createProductDetailResponse(product: Product): ProductDetailResponse {
        val price = detailProductRepository.findMinPriceByProduct(product)

        return ProductDetailResponse(
            name = product.name,
            isDiscount = product.isDiscount,
            discountDegree = product.discountDegree?.times(100)!!.roundToInt(),
            price = price,
            discountPrice = product.discountDegree?.times(price)!!.roundToInt(),
            company = product.company,
            images = product.images.map(ProductImageResponse::of),
            options = product.options.map(ProductOptionResponse::of),
            delivery = ProductDeliveryResponse.of(product.delivery),
        )
    }
}