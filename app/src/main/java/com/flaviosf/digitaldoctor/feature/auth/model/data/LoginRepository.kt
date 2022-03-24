package com.flaviosf.digitaldoctor.feature.auth.model.data

import androidx.lifecycle.LiveData

class LoginRepository {

    fun login(email: String, password: String): Boolean =
        (email == "teste@teste.com" && password == "123456")

}