package com.john.yourproducthere.domain.models

import com.john.yourproducthere.infrastructure.network.vos.FakesQueryVo

object FakeProduct {
    fun getFakeProduct() =
        Product(
            id = FakesQueryVo.anyValue,
            title = FakesQueryVo.anyValue,
            price = 0.0,
            permalink = FakesQueryVo.anyValue,
            thumbnail = FakesQueryVo.anyValue
        )
}
