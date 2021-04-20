package com.fulora.app.sign_in

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.fulora.app.R
import com.fulora.app.create_account.CreateAccountFragment
import com.fulora.app.databinding.ActivitySignInBinding
import com.fulora.app.isValidEmail
import com.fulora.app.isValidPassword

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)

//        Spannable

        // TODO: Não deu muito certo
//        val spannable = SpannableString("Não tem uma conta? Criar conta.")
//            .setSpan(
//                ForegroundColorSpan(Color.BLUE),
//                18, 31,
//                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//            )
//
//        binding.textCreateAccount.text = spannable.toString()

        binding.buttonAccessAccount.setOnClickListener {
            login(binding.emailEditText.text.toString(), binding.passwordEditText.text.toString())
        }

        binding.textCreateAccount.setOnClickListener {
            // TODO: Adicionar uma fragment
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, SignInActivity::class.java)
        }
    }

    private fun login(email: String, password: String) {
        when {
            !email.isValidEmail() -> {
                binding.emailEditText.error = getString(R.string.error_email)
            }
            !password.isValidPassword() -> {
                binding.passwordEditText.error = getString(R.string.error_password)
            }
            else -> {
                // TODO: Criar o login
            }
        }
    }

}
