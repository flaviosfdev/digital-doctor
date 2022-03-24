package com.flaviosf.digitaldoctor.feature.auth.view.fragment.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.flaviosf.digitaldoctor.databinding.FragmentAuthDialogResetPasswordBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AuthDialogResetPasswordFragment : BottomSheetDialogFragment(), View.OnClickListener {

    private lateinit var binding: FragmentAuthDialogResetPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthDialogResetPasswordBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.updatePasswordButton.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view) {
            binding.updatePasswordButton -> {
                Toast.makeText(view.context, "teste", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val RESET_PASSWORD_TAG = "ResetPasswordDialog"
    }
}