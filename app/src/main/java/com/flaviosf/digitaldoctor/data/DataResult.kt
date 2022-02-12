package com.flaviosf.digitaldoctor.data

sealed class DataResult {
    data class Success(val data: String) : DataResult()
    data class Error(val error: String): DataResult()
    object Loading : DataResult()
}
