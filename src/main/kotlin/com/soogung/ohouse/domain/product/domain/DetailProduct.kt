package com.soogung.ohouse.domain.product.domain

import com.soogung.ohouse.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "tbl_detail_product")
class DetailProduct(
    @Column(length = 40, nullable = false)
    var name: String,

    @Column(nullable = false)
    var price: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id", nullable = false)
    var productOption: ProductOption,

    @Column(name = "detail_product_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
): BaseTimeEntity() {
}