package com.flaviosf.digitaldoctor.ui.auth.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.ui.auth.IAuthCallbacks
import com.google.android.material.button.MaterialButton


class AuthStepSignUpFragment : Fragment(R.layout.fragment_auth_step_sign_up) {
    private lateinit var callback: IAuthCallbacks

    private lateinit var backToLoginFragment: MaterialButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when(context) {
            !is IAuthCallbacks -> {
                throw RuntimeException("Interface ILoginCallbacks não foi implementada em LoginActivity")
            }
            else -> callback = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backToLoginFragment = view.findViewById(R.id.have_an_account_button)


        backToLoginFragment.setOnClickListener {
            callback.goToLoginFragment()
        }
    }

}