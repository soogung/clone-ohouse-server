package com.soogung.ohouse.domain.product.domain.repository

import com.soogung.ohouse.domain.product.domain.ProductDelivery
import org.springframework.data.jpa.repository.JpaRepository

interface ProductDeliveryRepository: JpaRepository<ProductDelivery, Long> {
}