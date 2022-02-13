package com.flaviosf.digitaldoctor.ui.auth.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.data.DataResult
import com.flaviosf.digitaldoctor.ui.auth.IAuthCallbacks
import com.flaviosf.digitaldoctor.ui.auth.fragment.dialog.AuthDialogForgotPasswordFragment
import com.flaviosf.digitaldoctor.ui.auth.viewmodel.AuthStepLoginViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class AuthStepLoginFragment : Fragment(R.layout.fragment_auth_step_login) {
    private lateinit var callback: IAuthCallbacks
    private val viewModelAuthStep: AuthStepLoginViewModel by viewModels()
    private val dialog = AuthDialogForgotPasswordFragment()

    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var loginButton: MaterialButton
    private lateinit var progressBar: ImageView
    private lateinit var forgotPasswordButton: MaterialButton
    private lateinit var signUpButton: MaterialButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            !is IAuthCallbacks -> {
                throw RuntimeException("Interface ILoginCallbacks não foi implementada em LoginActivity")
            }
            else -> callback = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email = view.findViewById(R.id.email_edit_text)
        password = view.findViewById(R.id.password_edit_text)
        loginButton = view.findViewById(R.id.login_button)
        progressBar = view.findViewById(R.id.progress_bar)
        forgotPasswordButton = view.findViewById(R.id.forgot_password_button)
        signUpButton = view.findViewById(R.id.dont_have_an_account_button)

        Glide.with(progressBar)
            .load(R.drawable.logo_animated)
            .apply(RequestOptions().override(72, 72))
            .into(progressBar)

        loginButton.setOnClickListener {
//            loginButton.visibility = View.INVISIBLE
//            progressBar.visibility = View.VISIBLE
//            signIn(
//                email = email.text.toString(),
//                password = password.text.toString()
//            )

            callback.goToSearchDoctorActivity()
        }

        forgotPasswordButton.setOnClickListener {
            dialog.show(parentFragmentManager, AuthDialogForgotPasswordFragment.FORGOT_PASS_TAG)
        }

        signUpButton.setOnClickListener {
            callback.goToSignUpFragment()
        }
    }

    private fun signIn(email: String, password: String) {
        viewModelAuthStep.signIn(email, password).observe(this) {
            when (it) {
                is DataResult.Loading -> {}
                is DataResult.Success -> {
                    Toast.makeText(
                        activity?.application,
                        "Fez Login!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is DataResult.Error -> {
                    loginButton.visibility = View.VISIBLE
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(
                        activity?.applicationContext,
                        "Deu Erro!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }

    }

}