package com.soogung.ohouse.domain.order.domain.repository

import com.soogung.ohouse.domain.order.domain.OrderBlock
import org.springframework.data.repository.CrudRepository

interface OrderBlockRepository: CrudRepository<OrderBlock, Long> {
}