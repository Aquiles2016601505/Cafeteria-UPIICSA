package com.example.upiicsa.cafeteria.home

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides


@Module
class MenuShopModule {

    @Provides
    fun provideMenuShopViewModelFactory() =
            MenuShopViewModel.Factory()

    @Provides
    fun provideSignInViewModel(activity: MenuShopActivity, factory: MenuShopViewModel.Factory): MenuShopViewModel =
            ViewModelProviders.of(activity, factory).get(MenuShopViewModel::class.java)

}