package com.example.upiicsa.cafeteria.signIn

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.EditorInfo
import com.example.upiicsa.cafeteria.R
import com.example.upiicsa.cafeteria.entity.Unauthorized
import com.example.upiicsa.cafeteria.home.MenuShopActivity
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

        passwordEditText.setOnEditorActionListener { _, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_SEND -> {
                    send.invoke(passwordEditText)
                    true
                }
                else -> false
            }
        }
        sendButton.setOnClickListener(send)
        signInViewModel.isSignIn.observe(this, signInObserver)
        signInViewModel.formError.observe(this, formErrorObserver)
    }

    private val send: (View) -> Unit = {
        signInViewModel.signIn(usernameEditText.text.toString(),passwordEditText.text.toString())
    }

    private val signInObserver = Observer<Boolean> {
        it?.let {
            if (it) {
                finish()
                startActivity(MenuShopActivity.newIntent(this))
            }
        }
    }

    private val formErrorObserver = Observer<Throwable> {
        it?.let {
            if (it is Unauthorized) {
                usernameEditText.error = getString(R.string.sign_in_error_forbidden)
            } else {
                Snackbar.make(coordinatorLayout, it.message
                        ?: "No conoce la causa del error", Snackbar.LENGTH_LONG).show()
            }
        }
    }

}
