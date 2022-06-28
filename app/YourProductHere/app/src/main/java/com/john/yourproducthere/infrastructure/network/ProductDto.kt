package com.john.yourproducthere.infrastructure.network

import com.john.yourproducthere.domain.models.Product
import com.john.yourproducthere.domain.models.ProductInquiry
import com.john.yourproducthere.infrastructure.network.vos.ProductVo

fun List<ProductVo>.toProductInquiry(): ProductInquiry {

    val products = this.map {
        Product(
            it.id,
            it.title,
            it.price,
            it.permalink,
            it.thumbnail
        )
    }

    return ProductInquiry(products)
}
