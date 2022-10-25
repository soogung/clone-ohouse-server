package com.soogung.ohouse.domain.order.domain

import com.soogung.ohouse.domain.product.domain.DetailProduct
import javax.persistence.*

@Entity
@Table(name = "tbl_order")
class Order(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "order_block_id")
    var orderBlock: OrderBlock,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "detail_product_id")
    var product: DetailProduct,

    @Column(nullable = false)
    var quantity: Int,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {
}