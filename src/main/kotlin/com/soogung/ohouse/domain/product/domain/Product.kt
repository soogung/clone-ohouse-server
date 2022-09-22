package com.soogung.ohouse.domain.product.domain

import com.soogung.ohouse.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "tbl_product")
class Product(
    @Column(length = 30, nullable = false)
    var name: String,

    @Column(nullable = false)
    var isDiscount: Boolean,

    @Column(nullable = true)
    var discountDegree: Double? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_delivery_id", nullable = false)
    var delivery: ProductDelivery,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL])
    val images: ArrayList<ProductImage> = arrayListOf(),

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL])
    val options: ArrayList<ProductOption> = arrayListOf(),

    @Column(name = "product_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

): BaseTimeEntity() {
}