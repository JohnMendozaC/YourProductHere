package com.john.yourproducthere.domain.list_product

import com.john.yourproducthere.domain.models.Product
import com.john.yourproducthere.domain.models.ProductInquiry

interface ProductsIntent {
    fun getListProducts(): ProductInquiry?
    fun loadListProducts(products: List<Product>)
    fun displayProductsScreen()
    fun displayEmptyElementScreen()
}