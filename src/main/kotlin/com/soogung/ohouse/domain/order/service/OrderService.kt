package com.soogung.ohouse.domain.order.service

import com.soogung.ohouse.domain.cart.domain.Cart
import com.soogung.ohouse.domain.cart.domain.repository.CartRepository
import com.soogung.ohouse.domain.cart.facade.CartFacade
import com.soogung.ohouse.domain.order.domain.Order
import com.soogung.ohouse.domain.order.domain.OrderBlock
import com.soogung.ohouse.domain.order.domain.repository.OrderBlockRepository
import com.soogung.ohouse.domain.order.domain.repository.OrderRepository
import com.soogung.ohouse.domain.order.presentation.dto.request.OrderRequest
import com.soogung.ohouse.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.math.roundToInt

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val orderBlockRepository: OrderBlockRepository,
    private val cartFacade: CartFacade,
    private val cartRepository: CartRepository,
    private val userFacade: UserFacade,
) {

    @Transactional
    fun execute(request: OrderRequest) {
        val orderBlock = orderBlockRepository.save(
            OrderBlock(user = userFacade.getCurrentUser()))
        val carts = request.carts.map { cartFacade.findCartById(it) }

        val orders = orderRepository.saveAll(carts.map { cartToOrder(it, orderBlock) })
        orderBlock.setPrice(getPrice(orders))
        cartRepository.deleteAll(carts)
    }

    private fun cartToOrder(cart: Cart, orderBlock: OrderBlock): Order {
        val price = if (cart.product.isDiscount) cart.detailProduct.price * cart.quantity
                    else cart.product.discountDegree!!.times(cart.detailProduct.price).roundToInt() * cart.quantity

        return Order(
            orderBlock = orderBlock,
            product = cart.detailProduct,
            quantity = cart.quantity,
            price = price
        )
    }

    private fun getPrice(orders: MutableIterable<Order>): Int {
        var price = 0
        orders.forEach {
            price += it.price
        }

        return price
    }
}