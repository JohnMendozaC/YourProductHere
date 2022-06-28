package com.john.yourproducthere.domain.search

import com.john.yourproducthere.domain.models.ProductInquiry

interface SearchIntent {
    fun watchTheScreenLoading(isLoading: Boolean)
    fun launchShowSearchResults(result: ProductInquiry)
    fun showError(codeError: Int?)
    fun isActiveNetwork(): Boolean
}