package com.example.upiicsa.cafeteria.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider


class MenuShopViewModel: ViewModel() {

    val menuList = MutableLiveData<List<MenuDescriptionModel>>()

    init {
        val menuListtest: List <MenuDescriptionModel> = listOf (MenuDescriptionModel ("1", "Pechuga Empanisada","Con ensalada , cebolla", "$10.20"), MenuDescriptionModel ("1", "Pechuga Empanisada","Con ensalada , cebolla", "$ 10.20"), MenuDescriptionModel ("1", "Pechuga Empanisada","Con ensalada , cebolla", "$ 10.20"))
        menuList.postValue(menuListtest)
    }

    @Suppress("UNCHECKED_CAST")
    class Factory() : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MenuShopViewModel() as T
        }
    }
}