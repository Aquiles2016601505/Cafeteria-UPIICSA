package com.example.upiicsa.cafeteria.data

import com.example.upiicsa.cafeteria.data.retrofit.RetrofitApiGateway
import com.example.upiicsa.cafeteria.data.retrofit.RetrofitModule
import dagger.Module
import dagger.Provides

@Module(includes = [RetrofitModule::class])
class DataModule {

    @Provides
    fun providesOrderRepository(retrofitOrderRepository: RetrofitApiGateway): ApiGateway = retrofitOrderRepository
}