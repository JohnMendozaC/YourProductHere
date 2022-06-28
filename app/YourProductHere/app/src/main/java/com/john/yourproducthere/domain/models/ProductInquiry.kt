package com.john.yourproducthere.domain.models

import java.io.Serializable

data class ProductInquiry(
    val products: List<Product>
) : Serializable
