package com.john.yourproducthere.domain

sealed class ProductsResolverResult<T> {
    data class Success<T>(val result: T) : ProductsResolverResult<T>()
    data class Error<T>(val errorCode: Int) : ProductsResolverResult<T>()
}
