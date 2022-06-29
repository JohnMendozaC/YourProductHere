package com.john.yourproducthere.domain.services

import com.john.yourproducthere.domain.services.reponse.ProductsResolverResult
import com.john.yourproducthere.domain.services.reponse.Status
import com.john.yourproducthere.domain.models.FakeProductInquiry.getFakeProductInquiry
import com.john.yourproducthere.domain.models.ProductInquiry
import com.john.yourproducthere.infrastructure.network.daos.ProductDaoRetroFit
import com.john.yourproducthere.infrastructure.network.vos.FakesQueryVo.getEmptyQueryVo
import com.john.yourproducthere.infrastructure.network.vos.FakesQueryVo.getQueryVoWithProducts
import io.kotest.matchers.shouldBe
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class ProductServiceTest {

    private lateinit var productService: ProductService

    @MockK(relaxed = true)
    private lateinit var productDaoRetroFitMock: ProductDaoRetroFit

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        productService = ProductService(productDaoRetroFitMock)
    }

    @Test
    fun `Given an empty query response When the query is performed Then the answer should be the error 'empty list'`() =
        runBlocking {
            `given an empty query response`()

            val response = `when the query is performed`()

            `then the answer should be the error 'empty list'`(response)
        }

    @Test
    fun `Given a null query response When the query is performed Then the answer should be the error 'empty list'`() =
        runBlocking {
            `given a null query response`()

            val response = `when the query is performed`()

            `then the answer should be the error 'empty list'`(response)
        }

    @Test
    fun `Given an empty query response When the query is performed Then the response should be successful`() =
        runBlocking {
            `given a query response with products`()

            val response = `when the query is performed`()

            `then the response should be successful`(response)
        }

    private fun `given an empty query response`() {
        coEvery { productDaoRetroFitMock.searchProduct(any()) } returns (Response.success(
            getEmptyQueryVo()
        ))
    }

    private fun `given a null query response`() {
        coEvery { productDaoRetroFitMock.searchProduct(any()) } returns (Response.success(null))
    }

    private fun `given a query response with products`() {
        coEvery { productDaoRetroFitMock.searchProduct(any()) } returns (Response.success(
            getQueryVoWithProducts()
        ))
    }

    private suspend fun `when the query is performed`(): ProductsResolverResult<ProductInquiry> {
        return productService.searchProduct(dummyQuery)
    }

    private fun `then the answer should be the error 'empty list'`(response: ProductsResolverResult<ProductInquiry>) {
        response shouldBe ProductsResolverResult.Error(Status.EMPTY_LIST.code)
    }

    private fun `then the response should be successful`(response: ProductsResolverResult<ProductInquiry>) {
        response shouldBe ProductsResolverResult.Success(getFakeProductInquiry())
    }

    companion object {
        const val dummyQuery = "anyQuery"
    }
}
