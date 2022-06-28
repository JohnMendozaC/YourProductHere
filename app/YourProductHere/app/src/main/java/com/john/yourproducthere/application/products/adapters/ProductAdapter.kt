package com.john.yourproducthere.application.products.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.john.yourproducthere.application.products.adapters.viewholders.ProductViewHolder
import com.john.yourproducthere.application.products.fragments.list_product.EventListProduct
import com.john.yourproducthere.databinding.ItemProductBinding
import com.john.yourproducthere.domain.models.Product

class ProductAdapter(private val eventListProduct: EventListProduct) : ListAdapter<Product, ProductViewHolder>(CategoryDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            eventListProduct,
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class CategoryDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem == newItem
}