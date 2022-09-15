package com.soogung.ohouse.domain.product.presentation.dto.request

import com.soogung.ohouse.domain.product.domain.Product
import com.soogung.ohouse.domain.product.domain.ProductOption
import org.hibernate.validator.constraints.Length
import javax.validation.Valid

data class ProductOptionRequest(
    @field:Length(min = 2, max = 40)
    val option: String,

    @field:Valid
    val detailProducts: List<DetailProductRequest>
) {
    fun toEntity(product: Product): ProductOption {
        return ProductOption(
            name = option,
            product = product
        )
    }
}