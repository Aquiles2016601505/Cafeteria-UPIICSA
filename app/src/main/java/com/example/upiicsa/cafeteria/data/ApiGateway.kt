package com.example.upiicsa.cafeteria.data

import com.example.upiicsa.cafeteria.entity.Account

interface ApiGateway {
    fun signIn(username: String, password: String): Account
}