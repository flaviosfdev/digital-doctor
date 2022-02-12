package com.flaviosf.digitaldoctor.util

import android.content.Context
import android.widget.Toast

class Utils {

    companion object {
        fun toast(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }
}
