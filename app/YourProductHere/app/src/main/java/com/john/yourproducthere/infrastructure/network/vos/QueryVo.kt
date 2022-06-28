package com.john.yourproducthere.infrastructure.network.vos

import com.google.gson.annotations.SerializedName

data class QueryVo(
    @field:SerializedName("results") val results: List<ProductVo>
)
