package com.flaviosf.digitaldoctor.ui.auth.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.ui.auth.dialog.DialogResetPasswordFragment.Companion.RESET_PASS_TAG
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton


class DialogForgotPasswordFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dialog_forgot_password, container, false)
        val dialog = DialogResetPasswordFragment()
        val continueButton = view.findViewById<MaterialButton>(R.id.continue_button)
        continueButton.setOnClickListener {
            dialog.show(parentFragmentManager, RESET_PASS_TAG)
        }

        return view

    }

    companion object {
        const val FORGOT_PASS_TAG = "ForgotPasswordDialog"
    }

}