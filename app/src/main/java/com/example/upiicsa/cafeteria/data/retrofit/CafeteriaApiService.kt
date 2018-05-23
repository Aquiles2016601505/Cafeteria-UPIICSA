package com.example.upiicsa.cafeteria.data.retrofit

import com.example.upiicsa.cafeteria.data.retrofit.model.AccountDataModel
import com.example.upiicsa.cafeteria.data.retrofit.model.SignInResponseDataModel
import retrofit2.Call
import retrofit2.http.*


interface CafeteriaApiService {
    @POST("user/login")
    fun signIn(@Body user: AccountDataModel): Call<SignInResponseDataModel>
}
