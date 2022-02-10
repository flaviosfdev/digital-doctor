package com.flaviosf.digitaldoctor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton


class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dialog = ForgotPasswordDialogFragment()
        val forgotPasswordButton = view.findViewById<MaterialButton>(R.id.forgot_password_button)

        forgotPasswordButton.setOnClickListener {
            dialog.show(parentFragmentManager, ForgotPasswordDialogFragment.TAG )
        }
    }
}