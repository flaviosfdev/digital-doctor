package com.flaviosf.digitaldoctor.feature.auth.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.databinding.FragmentAuthStepLoginBinding
import com.flaviosf.digitaldoctor.feature.auth.view.fragment.dialog.AuthDialogForgotPasswordFragment
import com.flaviosf.digitaldoctor.feature.auth.viewmodel.AuthStepLoginViewModel
import com.google.android.material.snackbar.Snackbar

class AuthStepLoginFragment : Fragment() {

    private lateinit var binding: FragmentAuthStepLoginBinding
    private val viewModel: AuthStepLoginViewModel by viewModels()
    private val dialog = AuthDialogForgotPasswordFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthStepLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupProgress()

        viewModel.progressBar.observe(viewLifecycleOwner) { progressVisible ->
            if (progressVisible) {
                binding.progressBar.visibility = View.VISIBLE
                binding.loginButton.visibility = View.INVISIBLE
            } else {
                binding.progressBar.visibility = View.INVISIBLE
                binding.loginButton.visibility = View.VISIBLE
            }
        }

        viewModel.isValidLogin.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(AuthStepLoginFragmentDirections.actionLoginFragmentToSearchDoctorNavGraph())
            } else {
                Snackbar.make(
                    binding.root,
                    "Verifique se os dados estão corretos",
                    Snackbar.LENGTH_LONG
                ).setAction("Fechar") {}.show()
            }
        }

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            viewModel.login(email, password)
        }

        binding.forgotPasswordButton.setOnClickListener {
            dialog.show(parentFragmentManager, AuthDialogForgotPasswordFragment.FORGOT_PASSWORD_TAG)
        }

        binding.dontHaveAnAccountButton.setOnClickListener {
            findNavController()
                .navigate(
                    AuthStepLoginFragmentDirections
                        .actionLoginFragmentToSignUpFragment()
                )
        }
    }

    private fun setupProgress() {
        Glide.with(binding.progressBar.context)
            .applyDefaultRequestOptions(RequestOptions().override(72, 72))
            .load(R.drawable.loading)
            .into(binding.progressBar)
    }


}