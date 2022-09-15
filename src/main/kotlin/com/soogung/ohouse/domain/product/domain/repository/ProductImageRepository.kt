package com.soogung.ohouse.domain.product.domain.repository

import com.soogung.ohouse.domain.product.domain.ProductImage
import org.springframework.data.jpa.repository.JpaRepository

interface ProductImageRepository: JpaRepository<ProductImage, Long> {
}