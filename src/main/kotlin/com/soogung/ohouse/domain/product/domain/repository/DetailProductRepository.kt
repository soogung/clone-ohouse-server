package com.soogung.ohouse.domain.product.domain.repository

import com.soogung.ohouse.domain.product.domain.DetailProduct
import org.springframework.data.jpa.repository.JpaRepository

interface DetailProductRepository: JpaRepository<DetailProduct, Long> {
}