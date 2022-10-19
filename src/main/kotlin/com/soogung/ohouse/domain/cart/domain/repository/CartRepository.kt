package com.soogung.ohouse.domain.cart.domain.repository

import com.soogung.ohouse.domain.cart.domain.Cart
import com.soogung.ohouse.domain.product.domain.DetailProduct
import com.soogung.ohouse.domain.product.domain.Product
import com.soogung.ohouse.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface CartRepository: JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c WHERE c.user = :user")
    fun findCartByUser(user: User): List<Cart>

    @Query("SELECT c FROM Cart c WHERE c.user = :user AND c.detailProduct = :detailProduct")
    fun findCartByUserAndDetailProduct(user: User, detailProduct: DetailProduct): Cart?

    @Modifying
    @Transactional
    @Query("DELETE FROM Cart c WHERE c.user = :user AND c.product.id = :productId")
    fun deleteCartsByUserAndProduct(user: User, productId: Long);

    @Modifying
    @Transactional
    @Query("DELETE FROM Cart c WHERE c.user = :user AND c.detailProduct.id = :detailProductId")
    fun deleteCartByUserAnAndDetailProduct(user: User, detailProductId: Long);
}