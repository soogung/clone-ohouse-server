package com.soogung.ohouse.domain.cart.domain.repository

import com.soogung.ohouse.domain.cart.domain.Cart
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository: JpaRepository<Cart, Long> {

}