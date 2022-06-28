package com.john.yourproducthere.infrastructure.network

import com.john.yourproducthere.BuildConfig.BaseUrlMeli
import com.john.yourproducthere.infrastructure.network.daos.ProductDaoRetroFit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    fun create(): ProductDaoRetroFit {
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        return Retrofit.Builder()
            .baseUrl(BaseUrlMeli)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductDaoRetroFit::class.java)
    }
}
