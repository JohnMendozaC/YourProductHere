package com.john.yourproducthere.infrastructure.network.vos

object FakeProductVo {
    fun getFakeProductsVo() = listOf(
        ProductVo(
            id = FakesQueryVo.anyValue,
            title = FakesQueryVo.anyValue,
            price = 0.0,
            permalink = FakesQueryVo.anyValue,
            thumbnail = FakesQueryVo.anyValue
        )
    )
}
