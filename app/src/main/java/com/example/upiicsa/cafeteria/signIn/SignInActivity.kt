package com.example.upiicsa.cafeteria.signIn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.EditorInfo
import com.example.upiicsa.cafeteria.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.sign_in_activity.*
import javax.inject.Inject


class SignInActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context) = Intent(context, SignInActivity::class.java)
    }

    @Inject
    lateinit var signInViewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.sign_in_activity)
        sendButton.setOnClickListener({
            signInViewModel.signIn()

        }
        )

        passwordEditText.setOnEditorActionListener { _, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_SEND -> {
                    send.invoke(passwordEditText)
                    true
                }
                else -> false
            }
        }

    }

    private val send: (View) -> Unit = {
        signInViewModel.signIn()
    }

}
