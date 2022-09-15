package com.soogung.ohouse.domain.product.domain.repository

import com.soogung.ohouse.domain.product.domain.ProductOption
import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionRepository: JpaRepository<ProductOption, Long> {
}