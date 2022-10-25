package com.soogung.ohouse.domain.order.domain.repository

import com.soogung.ohouse.domain.order.domain.Order
import org.springframework.data.repository.CrudRepository

interface OrderRepository: CrudRepository<Order, Long> {
}