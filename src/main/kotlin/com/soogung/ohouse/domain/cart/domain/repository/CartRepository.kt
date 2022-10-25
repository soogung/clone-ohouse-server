package com.soogung.ohouse.domain.cart.domain.repository

import com.soogung.ohouse.domain.cart.domain.Cart
import com.soogung.ohouse.domain.product.domain.DetailProduct
import com.soogung.ohouse.domain.product.domain.Product
import com.soogung.ohouse.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface CartRepository: JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c WHERE c.id = :id")
    fun findCartById(id: Long): Cart?

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

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Cart c SET c.quantity = :quantity WHERE c.id = :cartId")
    fun updateCartQuantityByUserAndDetailProduct(quantity: Int, cartId: Long);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tbl_cart (quantity, product_id, product_option_id, detail_product_id, user_id) " +
        "VALUES (:#{#c.quantity},:#{#c.product.id},:#{#c.productOption.id},:#{#c.detailProduct.id},:#{#c.user.id})",
        nativeQuery = true)
    fun save(@Param("c") cart: Cart);
}