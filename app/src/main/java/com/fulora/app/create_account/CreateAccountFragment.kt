package com.fulora.app.create_account

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.fulora.app.R
import com.fulora.app.databinding.FragmentCreateAccountBinding
import com.fulora.app.isValidEmail
import com.fulora.app.isValidPassword
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * A [Fragment] subclass.
 *
 * This fragment is to user create account.
 */
class CreateAccountFragment : Fragment() {

    private lateinit var binding: FragmentCreateAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_account, container, false)


        // TODO: Não deu muito certo
//        binding.textSignIn.text = SpannableString(getString(R.string.text_access_account))
//            .setSpan(
//                ForegroundColorSpan(Color.BLUE),
//                17, 31,
//                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//            ).toString()

        binding.buttonCreateAccount.setOnClickListener {
            createAccount(binding.nomeEditText.text.toString(), binding.emailEditText.text.toString(), binding.passwordEditText.text.toString())
        }

        binding.textSignIn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    private fun createAccount(nome: String, email: String, password: String) {
        when {
            nome.isEmpty() -> {
                binding.nomeEditText.error = getString(R.string.error_name)
            }
            !email.isValidEmail() -> {
                binding.emailEditText.error = getString(R.string.error_email)
            }
            !password.isValidPassword() -> {
                binding.passwordEditText.error = getString(R.string.error_password)
            }
            else -> {
                // TODO: Criar a funcionalidade de criar a conta
            }
        }
    }
}