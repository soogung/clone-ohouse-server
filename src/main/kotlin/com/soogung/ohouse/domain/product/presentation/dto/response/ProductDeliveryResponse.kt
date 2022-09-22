package com.soogung.ohouse.domain.product.presentation.dto.response

import com.soogung.ohouse.domain.product.domain.ProductDelivery
import com.soogung.ohouse.domain.product.domain.type.DeliveryType

data class ProductDeliveryResponse(
    val price: Int,
    val freeShippingPrice: Int?,
    val deliveryType: DeliveryType
) {
    companion object {
        fun of(delivery: ProductDelivery): ProductDeliveryResponse {
            return ProductDeliveryResponse(
                price = delivery.price,
                freeShippingPrice = delivery.freeShippingPrice,
                deliveryType = delivery.deliveryType
            )
        }
    }
}
