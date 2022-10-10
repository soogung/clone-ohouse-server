package com.soogung.ohouse.domain.cart.domain.repository

import com.soogung.ohouse.domain.cart.domain.Cart
import com.soogung.ohouse.domain.product.domain.DetailProduct
import com.soogung.ohouse.domain.product.domain.Product
import com.soogung.ohouse.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CartRepository: JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c WHERE c.user = :user")
    fun findCartByUser(user: User): List<Cart>

    @Query("SELECT c FROM Cart c WHERE c.user = :user AND c.detailProduct = :detailProduct")
    fun findCartByUserAndDetailProduct(user: User, detailProduct: DetailProduct): Cart?

    @Query("SELECT c FROM Cart c WHERE c.user = :user AND c.product = :product")
    fun findCartsByUserAndProduct(user: User, product: Product): List<Cart>
}