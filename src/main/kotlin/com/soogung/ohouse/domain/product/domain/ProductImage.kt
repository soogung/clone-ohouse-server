package com.soogung.ohouse.domain.product.domain

import com.soogung.ohouse.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "tbl_product_image")
class ProductImage(
    @Column(nullable = false)
    var imageUri: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    var product: Product,

    @Column(name = "product_image_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
): BaseTimeEntity() {
}