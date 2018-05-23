package com.example.upiicsa.cafeteria.usecase

import com.example.upiicsa.cafeteria.data.ApiGateway
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {
    @Provides
    fun provideSignInUseCase(cafeteriaGateway: ApiGateway): SignInUseCase =
            SignInUseCaseImpl(cafeteriaGateway)
}
