package com.soogung.ohouse.domain.product.service

import com.soogung.ohouse.domain.product.domain.Product
import com.soogung.ohouse.domain.product.domain.repository.*
import com.soogung.ohouse.domain.product.presentation.dto.request.CreateProductRequest
import com.soogung.ohouse.domain.product.presentation.dto.request.ProductOptionRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateProductService(
    private val productRepository: ProductRepository,
    private val productImageRepository: ProductImageRepository,
    private val productDeliveryRepository: ProductDeliveryRepository,
    private val productOptionRepository: ProductOptionRepository,
    private val detailProductRepository: DetailProductRepository,
) {
    @Transactional
    fun execute(request: CreateProductRequest) {
        val delivery = productDeliveryRepository.save(request.delivery.toEntity())
        val product = productRepository.save(request.toEntity(delivery))
        productImageRepository.saveAll(request.images.map { it.toEntity(product) })
        request.productOption.forEach { saveDetailProduct(it, product) }
    }

    fun saveDetailProduct(request: ProductOptionRequest, product: Product) {
        val option = productOptionRepository.save(request.toEntity(product))
        detailProductRepository.saveAll(request.detailProducts.map { it.toEntity(option) })
    }
}