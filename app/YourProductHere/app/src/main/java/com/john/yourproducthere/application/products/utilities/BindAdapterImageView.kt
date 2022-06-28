package com.john.yourproducthere.application.products.utilities

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(view: AppCompatImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(url.replace("http://","https://"))
            .override(200, 300)
            .into(view)
    }
}

@BindingAdapter("imageUrlDetail")
fun loadImageDetail(view: AppCompatImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(url.replace("http://","https://"))
            .override(600, 700)
            .into(view)
    }
}