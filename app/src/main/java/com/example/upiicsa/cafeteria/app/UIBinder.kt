package com.example.upiicsa.cafeteria.app

import com.example.upiicsa.cafeteria.signIn.SignInActivity
import com.example.upiicsa.cafeteria.signIn.SignInModule
import dagger.Module
import dagger.android.ContributesAndroidInjector



@Module
abstract class UIBinder {
    @ContributesAndroidInjector(modules = [(SignInModule::class)])
    abstract fun bindSignInActivity(): SignInActivity
}
