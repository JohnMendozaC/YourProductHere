package com.john.yourproducthere.application.products.fragments.list_product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.john.yourproducthere.R
import com.john.yourproducthere.application.products.adapters.ProductAdapter
import com.john.yourproducthere.application.products.fragments.shared.ParamsBundle
import com.john.yourproducthere.databinding.ProductsFragmentBinding
import com.john.yourproducthere.domain.list_product.ProductsIntent
import com.john.yourproducthere.domain.list_product.ProductsViewModel
import com.john.yourproducthere.domain.models.Product
import com.john.yourproducthere.domain.models.ProductInquiry
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment(), ProductsIntent {

    private val productsViewModel: ProductsViewModel by viewModels()
    private lateinit var binding: ProductsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProductsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNameToToolbar()
        subscribeOnProductsIntent()
        subscribeAdapterProductList()
        productsViewModel.loadProducts()
    }

    private fun setNameToToolbar() {
        with(requireActivity().findViewById<Toolbar>(R.id.toolbar)) {
            visibility = View.VISIBLE
            title = getText(R.string.list_of_products)
        }
    }

    private fun subscribeOnProductsIntent() {
        productsViewModel.onProductsIntent(this)
    }

    private fun subscribeAdapterProductList() {
        binding.productList.adapter = ProductAdapter(object : EventListProduct {
            override fun clickToProduct(product: Product) {
                findNavController().navigate(
                    R.id.action_productsFragment_to_productDetailsFragment, bundleOf(
                        ParamsBundle.PRODUCT.value to product
                    )
                )
            }
        })
    }

    override fun getListProducts() = arguments?.get(ParamsBundle.PRODUCTS.value) as ProductInquiry?

    override fun loadListProducts(products: List<Product>) {
        (binding.productList.adapter as ProductAdapter).submitList(products)
    }

    override fun displayProductsScreen() {
        binding.emptyProducts.visibility = View.GONE
        binding.productList.visibility = View.VISIBLE
    }

    override fun displayEmptyElementScreen() {
        binding.productList.visibility = View.GONE
        binding.emptyProducts.visibility = View.VISIBLE
    }
}
