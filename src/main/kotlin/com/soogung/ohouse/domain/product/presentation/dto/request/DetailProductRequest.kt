package com.soogung.ohouse.domain.product.presentation.dto.request

import com.soogung.ohouse.domain.product.domain.DetailProduct
import com.soogung.ohouse.domain.product.domain.ProductOption
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Min

data class DetailProductRequest(
    @field:Length(min = 2, max = 40)
    val name: String,

    @field:Min(1)
    val price: Int,
) {
    fun toEntity(productOption: ProductOption): DetailProduct {
        return DetailProduct(
            name = name,
            price = price,
            productOption = productOption
        )
    }
}