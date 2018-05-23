package com.example.upiicsa.cafeteria.data.retrofit

import com.example.upiicsa.cafeteria.data.ApiGateway
import com.example.upiicsa.cafeteria.data.retrofit.model.AccountDataModel
import com.example.upiicsa.cafeteria.entity.Account
import com.example.upiicsa.cafeteria.entity.Unauthorized
import okhttp3.Credentials

private const val UNAUTHORIZED = 401

class RetrofitApiGateway (private val cafeteriaApiService: CafeteriaApiService) : ApiGateway {

    override fun signIn(username: String, password: String): Account {
        val response = cafeteriaApiService.signIn(AccountDataModel(username,password)).execute()
        if (!response.isSuccessful && response.code() == UNAUTHORIZED) {
            throw Unauthorized()
        } else if (!response.isSuccessful) {
            throw Exception("Unknown error")
        }
        return response.body()?.account?.toAccount() ?: throw Exception("Unknown error")
    }

    private fun AccountDataModel.toAccount() = Account(
            email = email,
            password = password
    )
}