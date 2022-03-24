package com.flaviosf.digitaldoctor.feature.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flaviosf.digitaldoctor.feature.auth.model.data.LoginRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AuthStepLoginViewModel(
    private val loginRepository: LoginRepository = LoginRepository()
) : ViewModel() {

    private val _progressBar: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    private val _isValidLogin: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isValidLogin: LiveData<Boolean>
        get() = _isValidLogin

    fun login(email: String, password: String) {
        _progressBar.value = true
        viewModelScope.launch {
            delay(2000L)
            _isValidLogin.value = loginRepository.login(email, password)
            _progressBar.value = false
        }
    }
}
