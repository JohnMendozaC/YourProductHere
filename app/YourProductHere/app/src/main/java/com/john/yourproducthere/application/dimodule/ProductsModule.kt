package com.john.yourproducthere.application.dimodule

import com.john.yourproducthere.infrastructure.network.Api
import com.john.yourproducthere.infrastructure.network.daos.ProductDaoRetroFit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class ProductsModule {

    @Provides
    fun provideProductDaoRetroFit(): ProductDaoRetroFit = Api.create()
}