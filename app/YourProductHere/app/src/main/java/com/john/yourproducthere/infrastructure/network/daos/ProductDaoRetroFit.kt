package com.john.yourproducthere.infrastructure.network.daos

import com.john.yourproducthere.infrastructure.network.vos.QueryVo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductDaoRetroFit {
    @GET("search")
    suspend fun searchProduct(@Query("q") query: String): Response<QueryVo>
}
