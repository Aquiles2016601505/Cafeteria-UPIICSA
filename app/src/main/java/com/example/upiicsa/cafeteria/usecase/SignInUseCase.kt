package com.example.upiicsa.cafeteria.usecase

import com.example.upiicsa.cafeteria.data.ApiGateway
import com.example.upiicsa.cafeteria.entity.Account
import kotlin.concurrent.thread

interface SignInUseCase {
    fun execute(username: String, password: String, success: (Account) -> Unit, failure: ((Throwable) -> Unit)? = null)
}

class SignInUseCaseImpl(private val cafeteriaGateway: ApiGateway) : SignInUseCase {

    override fun execute(username: String, password: String, success: (Account) -> Unit, failure: ((Throwable) -> Unit)?) {
        thread {
            try {
                success.invoke(executeSync(username, password))
            } catch (t: Throwable) {
                failure?.invoke(t)
            }
        }
    }

    internal fun executeSync(username: String, password: String): Account {
        val account = cafeteriaGateway.signIn(username, password)
        return account
    }
}
