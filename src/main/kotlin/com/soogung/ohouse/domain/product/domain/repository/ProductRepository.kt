package com.soogung.ohouse.domain.product.domain.repository

import com.soogung.ohouse.domain.product.domain.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
}