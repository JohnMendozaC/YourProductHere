package com.john.yourproducthere.application.products.fragments.product_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.john.yourproducthere.R
import com.john.yourproducthere.application.products.fragments.shared.ParamsBundle
import com.john.yourproducthere.databinding.ProductDetailsFragmentBinding
import com.john.yourproducthere.domain.models.Product
import com.john.yourproducthere.domain.products_details.ProductDetailsViewModel
import com.john.yourproducthere.domain.products_details.ProductsDetailsIntent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment(), ProductsDetailsIntent {

    private val productDetailsViewModel: ProductDetailsViewModel by viewModels()
    private lateinit var binding: ProductDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProductDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNameToToolbar()
        subscribeOnProductsIntent()
        productDetailsViewModel.loadProduct()
    }

    private fun setNameToToolbar() {
        with(requireActivity().findViewById<Toolbar>(R.id.toolbar)) {
            visibility = View.VISIBLE
            title = getText(R.string.product_details)
        }
    }

    private fun subscribeOnProductsIntent() {
        productDetailsViewModel.onProductsDetailsIntent(this)
    }

    override fun getProduct() = arguments?.get(ParamsBundle.PRODUCT.value) as Product?

    override fun loadProduct(product: Product) {
        binding.productDetail = product
    }

    override fun displayProductScreen() {
        binding.emptyProductDetails.visibility = View.GONE
    }

    override fun displayEmptyElementScreen() {
        binding.emptyProductDetails.visibility = View.VISIBLE
    }
}
