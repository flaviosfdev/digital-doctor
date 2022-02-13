package com.flaviosf.digitaldoctor.model

data class Doctor(
    val name: String,
    val photo: String,
    val isFavorite: Boolean,
    val specialty: String,
    val experience: Int,
)