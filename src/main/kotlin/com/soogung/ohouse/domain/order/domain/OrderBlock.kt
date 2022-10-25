package com.soogung.ohouse.domain.order.domain

import com.soogung.ohouse.domain.user.domain.User
import javax.persistence.*

@Entity
@Table(name = "tbl_order_block")
class OrderBlock(
    @Column(nullable = false)
    var totalPrice: Int? = 0,

    @Column(nullable = false)
    var deliveryPrice: Int? = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    var user: User,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
) {
    fun setPrice(totalPrice: Int) {
        this.totalPrice = totalPrice
    }
}