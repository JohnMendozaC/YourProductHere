package com.john.yourproducthere.application.products.fragments.search

import com.john.yourproducthere.R
import com.john.yourproducthere.application.products.ProductsStatus

object SearchErrorHandler {

    fun resolverError(codeError: Int?): Int = when (codeError) {
        ProductsStatus.EMPTY_LIST.value -> R.string.no_results_found
        ProductsStatus.NOT_NETWORK_ACTIVE.value -> R.string.no_network_active
        else -> R.string.no_product_to_show
    }
}
