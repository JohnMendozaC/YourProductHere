package com.john.yourproducthere.application.products.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.john.yourproducthere.application.products.fragments.list_product.EventListProduct
import com.john.yourproducthere.databinding.ItemProductBinding
import com.john.yourproducthere.domain.models.Product

class ProductViewHolder(
    private val eventListProduct: EventListProduct,
    private val itemProductBinding: ItemProductBinding
) : RecyclerView.ViewHolder(itemProductBinding.root) {

    fun bind(item: Product) {
        itemProductBinding.product = item
        itemProductBinding.setClickListener {
            eventListProduct.clickToProduct(item)
        }
        itemProductBinding.executePendingBindings()
    }
}