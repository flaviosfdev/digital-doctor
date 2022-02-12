package com.flaviosf.digitaldoctor.ui.auth.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.ui.auth.ILoginCallbacks
import com.flaviosf.digitaldoctor.ui.auth.dialog.DialogForgotPasswordFragment
import com.google.android.material.button.MaterialButton


class SignUpFragment : Fragment() {
    private lateinit var callback: ILoginCallbacks

    private lateinit var backToLoginFragment: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when(context) {
            !is ILoginCallbacks -> {
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