package com.example.upiicsa.cafeteria.data.retrofit.model

import com.google.gson.annotations.SerializedName

data class AccountDataModel(
        @SerializedName("email") var email: String = "",
        @SerializedName("password") var password: String = ""
)