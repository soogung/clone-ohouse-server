package com.soogung.ohouse.domain.product.domain.repository

import com.soogung.ohouse.domain.product.domain.Product
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProductRepository: JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.id = :id")
    fun findProductById(id: Long): Product?

    @Query("SELECT p FROM Product p ORDER BY function('RAND')")
    fun findRandomProducts(pageable: Pageable): List<Product>
}