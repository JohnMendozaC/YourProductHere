package com.john.yourproducthere.application.products.utilities

import android.content.Intent
import android.net.Uri
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BindingAdapter

@BindingAdapter("linkDirection")
fun sendUrl(view: TextView, url: String?) {
    if (!url.isNullOrEmpty()) {
        view.setOnClickListener {
            Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(url) }.also {
                startActivity(view.context, it, null)
            }
        }
    }
}