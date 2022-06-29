package com.john.yourproducthere.domain.search

import com.john.yourproducthere.application.products.ProductsStatus
import com.john.yourproducthere.domain.services.reponse.ProductsResolverResult
import com.john.yourproducthere.domain.models.FakeProductInquiry.getFakeProductInquiry
import com.john.yourproducthere.domain.models.ProductInquiry
import com.john.yourproducthere.domain.services.ProductService
import io.kotest.assertions.withClue
import io.kotest.matchers.shouldBe
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any

class SearchViewModelTest {

    private lateinit var searchViewModel: SearchViewModel

    @MockK(relaxed = true)
    private lateinit var productService: ProductService

    @MockK(relaxed = true)
    private lateinit var searchIntent: SearchIntent

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        searchViewModel = SearchViewModel(productService)
        searchViewModel.onSearchIntent(searchIntent)
    }

    @Test
    fun `Given an answer that it does not have active internet When the request is made to search for the products Then it should notify the error code without internet`() {
        `given an answer that it does not have active internet`()

        `when the request is made to search for the products`()

        `then it should notify the error code without internet`()
    }

    @Test
    fun `Given an answer that it does have active internet When the request is made to search for the products Then the call for product query should be made`() {
        `given an answer that it does have active internet`()

        `when the request is made to search for the products`()

        `then the call for product query should be made`()
    }

    @Test
    fun `Given a successful response from the product search When the request is made to search for the products Then should be launch to show search results`() {
        `given a successful response from the product search`()

        `when the request is made to search for the products`()

        `then should be launch to show search results`()
    }

    @Test
    fun `Given a failed response from the product search When the request is made to search for the products Then it should notify the error code of query`() {
        `given a failed response from the product search`()

        `when the request is made to search for the products`()

        `then it should notify the error code of query`()
    }

    private fun `given an answer that it does not have active internet`() {
        every { searchIntent.isActiveNetwork() } returns false
    }

    private fun `given an answer that it does have active internet`() {
        every { searchIntent.isActiveNetwork() } returns true
    }

    private fun `given a successful response from the product search`() {
        every { searchIntent.isActiveNetwork() } returns true
        coEvery { productService.searchProduct(any()) } returns ProductsResolverResult.Success(
            getFakeProductInquiry()
        )
    }

    private fun `given a failed response from the product search`() {
        every { searchIntent.isActiveNetwork() } returns true
        coEvery { productService.searchProduct(any()) } returns ProductsResolverResult.Error(
            anyError
        )
    }

    private fun `when the request is made to search for the products`() {
        searchViewModel.searchProduct(anyQuery)
    }

    private fun `then it should notify the error code without internet`() {
        val codeError = slot<Int>()
        verify {
            searchIntent.showError(capture(codeError))
        }
        withClue("the error code reported should be not network active") {
            codeError.captured shouldBe ProductsStatus.NOT_NETWORK_ACTIVE.value
        }
    }

    private fun `then the call for product query should be made`() {
        val query = slot<String>()
        coVerify {
            productService.searchProduct(capture(query))
        }
        withClue("the query should be the one sent by the user") {
            query.captured shouldBe anyQuery
        }
    }

    private fun `then should be launch to show search results`() {
        val result = slot<ProductInquiry>()
        verify {
            searchIntent.launchShowSearchResults(capture(result))
        }
        withClue("the result should be the one sent by the service of meli") {
            result.captured shouldBe getFakeProductInquiry()
        }
    }

    private fun `then it should notify the error code of query`() {
        val codeError = slot<Int>()
        verify {
            searchIntent.showError(capture(codeError))
        }
        withClue("the error code reported should be any error") {
            codeError.captured shouldBe anyError
        }
    }

    companion object {
        const val anyQuery = "anyQuery"
        const val anyError = -1
    }
}
