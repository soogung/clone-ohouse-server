package com.soogung.ohouse.domain.product.domain.repository

import com.soogung.ohouse.domain.product.domain.DetailProduct
import com.soogung.ohouse.domain.product.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface DetailProductRepository: JpaRepository<DetailProduct, Long> {

    @Query("SELECT min(p.price) FROM DetailProduct p WHERE p.productOption.product = :product")
    fun findMinPriceByProduct(product: Product): Int

    @Query("SELECT p FROM DetailProduct p WHERE p.id = :id")
    fun findDetailProductById(id: Long): DetailProduct?
}