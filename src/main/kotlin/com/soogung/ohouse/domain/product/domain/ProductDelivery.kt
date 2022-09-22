package com.soogung.ohouse.domain.product.domain

import com.soogung.ohouse.domain.product.domain.type.DeliveryType
import com.soogung.ohouse.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "tbl_product_delivery")
class ProductDelivery(
    @Column(nullable = false)
    var price: Int,

    @Column(nullable = true)
    var freeShippingPrice: Int? = 0,

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    var deliveryType: DeliveryType,

    @Column(name = "product_delivery_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
): BaseTimeEntity() {
}