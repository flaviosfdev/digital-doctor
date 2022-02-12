package com.flaviosf.digitaldoctor.ui.auth.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flaviosf.digitaldoctor.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DialogResetPasswordFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dialog_reset_password, container, false)


        return view
    }


    companion object {
        const val RESET_PASS_TAG = "ResetPasswordDialog"
    }
}