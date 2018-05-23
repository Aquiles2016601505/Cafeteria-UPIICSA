package com.example.upiicsa.cafeteria.signIn

import android.arch.lifecycle.ViewModelProviders
import com.example.upiicsa.cafeteria.usecase.SignInUseCase
import dagger.Module
import dagger.Provides


@Module
class SignInModule {
    @Provides
    fun provideSignInViewModelFactory(signInUseCase: SignInUseCase) =
            SignInViewModel.Factory(signInUseCase)

    @Provides
    fun provideSignInViewModel(activity: SignInActivity, factory: SignInViewModel.Factory): SignInViewModel =
            ViewModelProviders.of(activity, factory).get(SignInViewModel::class.java)

}
