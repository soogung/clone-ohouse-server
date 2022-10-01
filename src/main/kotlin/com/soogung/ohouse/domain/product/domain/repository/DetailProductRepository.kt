package com.soogung.ohouse.domain.product.domain.repository

import com.soogung.ohouse.domain.product.domain.DetailProduct
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface DetailProductRepository: JpaRepository<DetailProduct, Long> {

    @Query("SELECT p FROM DetailProduct p WHERE p.id = :id")
    fun findDetailProductById(id: Long): DetailProduct?
}