package com.flaviosf.digitaldoctor.feature.auth.view.fragment.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flaviosf.digitaldoctor.feature.auth.view.fragment.dialog.AuthDialogResetPasswordFragment.Companion.RESET_PASSWORD_TAG
import com.flaviosf.digitaldoctor.databinding.FragmentAuthDialogForgotPasswordBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AuthDialogForgotPasswordFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentAuthDialogForgotPasswordBinding
    private val dialog = AuthDialogResetPasswordFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthDialogForgotPasswordBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.continueButton.setOnClickListener {
            showDialogResetPassword()
        }
    }

    private fun showDialogResetPassword() {
        dialog.show(parentFragmentManager, RESET_PASSWORD_TAG)
    }

    companion object {
        const val FORGOT_PASSWORD_TAG = "ForgotPasswordDialog"
    }

}