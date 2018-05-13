package com.example.upiicsa.cafeteria.signIn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
        enviarButton.setOnClickListener({
            pruebaTextView.setText(signInViewModel.upperCase(usernameEditText.text.toString()))
            prueba2TextView.setText(signInViewModel.upperCase(usernameEditText.text.toString()))
        }
        )


    }

}
