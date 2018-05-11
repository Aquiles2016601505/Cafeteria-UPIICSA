package com.example.upiicsa.cafeteria.signIn

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider


class SignInViewModel() : ViewModel() {
    val isSignIn = MutableLiveData<Boolean>()
    val formError = MutableLiveData<Throwable>()

    init {
        isSignIn.value = false
    }

    fun upperCase(texto : String) = texto.toUpperCase()


    @Suppress("UNCHECKED_CAST")
    class Factory() : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SignInViewModel() as T
        }
    }
}