package com.example.upiicsa.cafeteria.signIn

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.upiicsa.cafeteria.usecase.SignInUseCase

class SignInViewModel(private val signInUseCase: SignInUseCase) : ViewModel() {
    val isSignIn = MutableLiveData<Boolean>()
    val formError = MutableLiveData<Throwable>()

    init {
        isSignIn.value = false
    }

    fun signIn(username :String,password :String){
        signInUseCase.execute(username, password, {
            isSignIn.postValue(true)
        }, {
            formError.postValue(it)
        })
    }


    @Suppress("UNCHECKED_CAST")
    class Factory(private val signInUseCase: SignInUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SignInViewModel(signInUseCase) as T
        }
    }
}