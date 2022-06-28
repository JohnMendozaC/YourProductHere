package com.john.yourproducthere.domain.products_details

import androidx.lifecycle.ViewModel
import com.john.yourproducthere.domain.models.Product

class ProductDetailsViewModel : ViewModel() {

    private lateinit var product: Product
    private lateinit var productsDetailsIntent: ProductsDetailsIntent

    fun onProductsDetailsIntent(productsDetailsIntent: ProductsDetailsIntent) {
        this.productsDetailsIntent = productsDetailsIntent
    }

    fun loadProduct() {
        validateProductToDisplay()
    }

    private fun validateProductToDisplay() {
        val newProduct = productsDetailsIntent.getProduct()
        if (newProduct == null) {
            productsDetailsIntent.displayEmptyElementScreen()
        } else {
            product = newProduct
            showProducts()
        }
    }

    private fun showProducts() {
        productsDetailsIntent.loadProduct(product)
        productsDetailsIntent.displayProductScreen()
    }
}
