package com.john.yourproducthere.domain.products_details

import com.john.yourproducthere.domain.models.Product

interface ProductsDetailsIntent {
    fun getProduct(): Product?
    fun loadProduct(product: Product)
    fun displayProductScreen()
    fun displayEmptyElementScreen()
}