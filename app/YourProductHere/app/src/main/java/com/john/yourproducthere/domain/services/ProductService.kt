package com.john.yourproducthere.domain.services

import com.john.yourproducthere.domain.services.reponse.ProductsResolverResult
import com.john.yourproducthere.domain.services.reponse.Status
import com.john.yourproducthere.domain.models.ProductInquiry
import com.john.yourproducthere.infrastructure.network.daos.ProductDaoRetroFit
import com.john.yourproducthere.infrastructure.network.toProductInquiry
import javax.inject.Inject

class ProductService @Inject constructor(
    private val productDaoRetroFit: ProductDaoRetroFit
) {

    suspend fun searchProduct(query: String): ProductsResolverResult<ProductInquiry> {
        val results = productDaoRetroFit.searchProduct(query).body()?.results
        if (results.isNullOrEmpty())
            return ProductsResolverResult.Error(Status.EMPTY_LIST.code)
        return ProductsResolverResult.Success(results.toProductInquiry())
    }
}
