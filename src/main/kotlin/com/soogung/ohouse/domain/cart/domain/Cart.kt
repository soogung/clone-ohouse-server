package com.soogung.ohouse.domain.cart.domain

import com.soogung.ohouse.domain.product.domain.DetailProduct
import com.soogung.ohouse.domain.user.domain.User
import javax.persistence.*

@Entity
@Table(name = "tbl_cart")
class Cart(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    var product: DetailProduct,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User,

    @Column(nullable = false)
    var quantity: Int = 1,

    @Column(name = "cart_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
) {
}