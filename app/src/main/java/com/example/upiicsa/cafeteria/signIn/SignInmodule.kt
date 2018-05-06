package com.example.upiicsa.cafeteria.signIn

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides


@Module
class SignInModule {
    @Provides
    fun provideSignInViewModelFactory() =
            SignInViewModel.Factory()

    @Provides
    fun provideSignInViewModel(activity: SignInActivity, factory: SignInViewModel.Factory): SignInViewModel =
            ViewModelProviders.of(activity, factory).get(SignInViewModel::class.java)

}
