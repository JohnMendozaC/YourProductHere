package com.john.yourproducthere.domain.search

import androidx.lifecycle.ViewModel
import com.john.yourproducthere.application.products.ProductsStatus
import com.john.yourproducthere.domain.ProductsResolverResult
import com.john.yourproducthere.domain.models.ProductInquiry
import com.john.yourproducthere.domain.services.ProductService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val productService: ProductService
) : ViewModel() {

    private lateinit var searchIntent: SearchIntent

    fun onSearchIntent(searchIntent: SearchIntent) {
        this.searchIntent = searchIntent
    }

    fun searchProduct(query: String) {
        validateIsActiveNetwork(query)
    }

    private fun validateIsActiveNetwork(query: String) {
        with(searchIntent) {
            if (isActiveNetwork()) {
                executeProductQuery(query)
            } else {
                showError(ProductsStatus.NOT_NETWORK_ACTIVE.value)
            }
        }
    }

    private fun executeProductQuery(query: String) {
        searchIntent.watchTheScreenLoading(isLoading = true)
        runBlocking {
            val productInquiry = productService.searchProduct(query)
            validateSearchStatus(productInquiry)
        }
    }

    private fun validateSearchStatus(result: ProductsResolverResult<ProductInquiry>) {
        with(searchIntent) {
            when (result) {
                is ProductsResolverResult.Success -> {
                    searchIntent.launchShowSearchResults(result.result)
                    watchTheScreenLoading(isLoading = false)
                }
                is ProductsResolverResult.Error -> {
                    showError(result.errorCode)
                    watchTheScreenLoading(isLoading = false)
                }
            }
        }
    }
}
