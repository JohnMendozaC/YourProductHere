package com.john.yourproducthere.infrastructure.network.vos

import com.john.yourproducthere.infrastructure.network.vos.FakeProductVo.getFakeProductsVo

object FakesQueryVo {

    const val anyValue = "AnyValue"

    fun getEmptyQueryVo() = QueryVo(
        results = listOf()
    )

    fun getQueryVoWithProducts() = QueryVo(
        results = getFakeProductsVo()
    )
}
