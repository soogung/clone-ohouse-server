package com.soogung.ohouse.domain.product.presentation.dto.request

import com.soogung.ohouse.domain.product.domain.Product
import com.soogung.ohouse.domain.product.domain.ProductDelivery
import org.hibernate.validator.constraints.Length
import javax.validation.Valid
import kotlin.math.min

data class CreateProductRequest(
    @field:Length(min = 2, max = 30)
    val name: String,

    @field:Length(min = 1, max = 20)
    val company: String,

    val isDiscount: Boolean,

    val discountDegree: Double?,

    @field:Valid
    val productOption: List<ProductOptionRequest>,

    @field:Valid
    val images: List<ProductImageRequest>,

    @field:Valid
    val delivery: ProductDeliveryRequest,
) {
    fun toEntity(delivery: ProductDelivery): Product {
        return Product(
            name = name,
            company = company,
            isDiscount = isDiscount,
            discountDegree = discountDegree,
            delivery = delivery,
        )
    }
}