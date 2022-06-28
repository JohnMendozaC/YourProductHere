package com.john.yourproducthere.domain.list_product

import com.john.yourproducthere.domain.models.FakeProductInquiry.getFakeProductInquiry
import com.john.yourproducthere.domain.models.Product
import io.kotest.assertions.withClue
import io.kotest.matchers.shouldBe
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class ProductsViewModelTest {

    private lateinit var productsViewModel: ProductsViewModel
    private val emptyProducts = null

    @MockK
    private lateinit var productsIntent: ProductsIntent

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        productsViewModel = ProductsViewModel()
        productsViewModel.onProductsIntent(productsIntent)
    }

    @Test
    fun `Given a successful product procurement When products are loaded Then the products returned by the meli service are charged`() {
        `given a successful product procurement`()

        `when products are loaded`()

        `then the products returned by the meli service are charged`()
    }

    @Test
    fun `Given a failed product procurement When products are loaded Then it should show the screen that there are no product`() {
        `given a failed product procurement`()

        `when products are loaded`()

        `then it should show the screen that there are no product`()
    }

    private fun `given a successful product procurement`() {
        every { productsIntent.displayProductsScreen() } returns Unit
        every { productsIntent.loadListProducts(any()) } returns Unit

        every { productsIntent.getListProducts() } returns getFakeProductInquiry()
    }

    private fun `given a failed product procurement`() {
        every { productsIntent.displayEmptyElementScreen() } returns Unit
        every { productsIntent.loadListProducts(any()) } returns Unit

        every { productsIntent.getListProducts() } returns emptyProducts
    }

    private fun `when products are loaded`() {
        productsViewModel.loadProducts()
    }

    private fun `then the products returned by the meli service are charged`() {
        val products = slot<List<Product>>()
        verify {
            productsIntent.loadListProducts(capture(products))
        }
        withClue("the products should be the one sent by the service of meli") {
            products.captured shouldBe getFakeProductInquiry().products
        }
    }

    private fun `then it should show the screen that there are no product`() {
        verify {
            productsIntent.displayEmptyElementScreen()
        }
    }
}
