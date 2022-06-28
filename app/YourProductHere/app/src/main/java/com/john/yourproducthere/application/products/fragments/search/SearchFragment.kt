package com.john.yourproducthere.application.products.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.john.yourproducthere.R
import com.john.yourproducthere.application.products.fragments.search.SearchErrorHandler.resolverError
import com.john.yourproducthere.application.products.fragments.shared.ParamsBundle
import com.john.yourproducthere.application.products.utilities.VerifyNetwork
import com.john.yourproducthere.databinding.SearchFragmentBinding
import com.john.yourproducthere.domain.models.ProductInquiry
import com.john.yourproducthere.domain.search.SearchIntent
import com.john.yourproducthere.domain.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(), SearchIntent {

    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var binding: SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideToolbar()
        subscribeOnSearchIntent()
        subscribeToClickSearch()
    }

    private fun hideToolbar() {
        with(requireActivity().findViewById<Toolbar>(R.id.toolbar)) {
            visibility = View.GONE
        }
    }

    private fun subscribeOnSearchIntent() {
        searchViewModel.onSearchIntent(this)
    }

    private fun subscribeToClickSearch() {
        binding.btnSearchProduct.setOnClickListener {
            val query = binding.etSearchProduct.text.toString()
            searchProduct(query)
        }
    }

    private fun searchProduct(query: String) {
        searchViewModel.searchProduct(query)
    }

    override fun watchTheScreenLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.loader.root.visibility = View.VISIBLE
        } else {
            binding.loader.root.visibility = View.GONE
        }
    }

    override fun launchShowSearchResults(result: ProductInquiry) {
        findNavController(this).navigate(
            R.id.action_searchFragment_to_productsFragment, bundleOf(
                ParamsBundle.PRODUCTS.value to result
            )
        )
    }

    override fun showError(codeError: Int?) {
        Snackbar.make(
            this.requireView(),
            resolverError(codeError),
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun isActiveNetwork() = VerifyNetwork.isActiveNetwork(requireContext())
}
