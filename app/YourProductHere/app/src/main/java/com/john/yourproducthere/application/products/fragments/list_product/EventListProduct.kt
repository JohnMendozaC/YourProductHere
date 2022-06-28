package com.john.yourproducthere.application.products.fragments.list_product

import com.john.yourproducthere.domain.models.Product

interface EventListProduct {
    fun clickToProduct(product: Product)
}