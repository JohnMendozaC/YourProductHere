package com.john.yourproducthere.domain.list_product

import androidx.lifecycle.ViewModel
import com.john.yourproducthere.domain.models.Product

class ProductsViewModel : ViewModel() {

    private lateinit var products: List<Product>
    private lateinit var productsIntent: ProductsIntent

    fun onProductsIntent(productsIntent: ProductsIntent) {
        this.productsIntent = productsIntent
    }

    fun loadProducts() {
        validateProductsToDisplay()
    }

    private fun validateProductsToDisplay() {
        val newProducts = productsIntent.getListProducts()?.products
        if (newProducts.isNullOrEmpty()) {
            productsIntent.displayEmptyElementScreen()
        } else {
            products = newProducts
            showProducts()
        }
    }

    private fun showProducts() {
        productsIntent.loadListProducts(products)
        productsIntent.displayProductsScreen()
    }
}
