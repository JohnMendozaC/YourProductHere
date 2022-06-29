package com.john.yourproducthere.domain.products_details

import com.john.yourproducthere.domain.models.FakeProduct.getFakeProduct
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

class ProductDetailsViewModelTest {

    private lateinit var productDetailsViewModel: ProductDetailsViewModel
    private val emptyProduct = null

    @MockK(relaxed = true)
    private lateinit var productsDetailsIntent: ProductsDetailsIntent

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        productDetailsViewModel = ProductDetailsViewModel()
        productDetailsViewModel.onProductsDetailsIntent(productsDetailsIntent)
    }

    @Test
    fun `Given a successful product procurement When product is loaded Then the product returned by the meli service is charged`() {
        `given a successful product procurement`()

        `when product is loaded`()

        `then the product returned by the meli service is charged`()
    }

    @Test
    fun `Given a failed product procurement When product is loaded Then it should show the screen that there is no product`() {
        `given a failed product procurement`()

        `when product is loaded`()

        `then it should show the screen that there is no product`()
    }

    private fun `given a successful product procurement`() {
        every { productsDetailsIntent.getProduct() } returns getFakeProduct()
    }

    private fun `given a failed product procurement`() {
        every { productsDetailsIntent.getProduct() } returns emptyProduct
    }

    private fun `when product is loaded`() {
        productDetailsViewModel.loadProduct()
    }

    private fun `then the product returned by the meli service is charged`() {
        val product = slot<Product>()
        verify {
            productsDetailsIntent.loadProduct(capture(product))
        }
        withClue("the product should be the one sent by the service of meli") {
            product.captured shouldBe getFakeProduct()
        }
    }

    private fun `then it should show the screen that there is no product`() {
        verify {
            productsDetailsIntent.displayEmptyElementScreen()
        }
    }
}
