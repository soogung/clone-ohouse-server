package com.soogung.ohouse.domain.cart.service

import com.soogung.ohouse.domain.cart.domain.repository.CartRepository
import com.soogung.ohouse.domain.product.facade.ProductFacade
import com.soogung.ohouse.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PopProductService(
    private val cartRepository: CartRepository,
    private val userFacade: UserFacade,
) {

    @Transactional
    fun execute(id: Long) {
        cartRepository.deleteCartsByUserAndProduct(
                userFacade.getCurrentUser(), id
        )
    }
}