package com.flaviosf.digitaldoctor.ui.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.flaviosf.digitaldoctor.data.DataResult
import com.flaviosf.digitaldoctor.data.ServiceAPI

class LoginViewModel(
    private val serviceAPI: ServiceAPI = ServiceAPI.instance
): ViewModel() {

    private val _progressBar: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    fun signIn(email: String, password: String): LiveData<DataResult> =
        serviceAPI.login(email = email, password = password)

}