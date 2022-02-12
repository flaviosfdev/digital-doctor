package com.flaviosf.digitaldoctor.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ServiceAPI {

    fun login(email: String, password: String): LiveData<DataResult> {

        val result = MutableLiveData<DataResult>()
        result.value = DataResult.Loading

        try {
            android.os.Handler().postDelayed({
                if (isValidLogin(email, password)) {
                    result.value = DataResult.Success("Logado")
                } else {
                    result.value = DataResult.Error("Dados inválidos")
                }
            }, 3000)
        } catch (e: InterruptedException) {
            Log.e(LOG_TAG, e.message ?: "")
        }
        return result
    }

    private fun isValidLogin(email: String, password: String): Boolean {
        return email == "teste@teste.com" && password == "123"
    }

    companion object {
        val instance: ServiceAPI by lazy { ServiceAPI() }
        private const val LOG_TAG = "LOGIN_TAG"
    }

}
