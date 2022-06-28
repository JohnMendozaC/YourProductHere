package com.john.yourproducthere.domain.models

import java.io.Serializable

data class Product(
    val id: String,
    val title: String?,
    val price: Double?,
    val permalink: String?,
    val thumbnail: String?
) : Serializable
