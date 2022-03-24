package com.flaviosf.digitaldoctor.feature.auth.model.data

import com.flaviosf.digitaldoctor.common.domain.model.doctor.Doctor


class MockDoctors {
    companion object {
        fun getDoctors() : List<Doctor> = listOf(
            Doctor(
                name = "Dr. Shruti Kedia",
                photo = "",
                isFavorite = true,
                specialty = "Dentist",
                experience = "10"
            ),
            Doctor(
                name = "Dr. Watamaniuk",
                photo = "",
                isFavorite = false,
                specialty = "Dentist",
                experience = "10"
            ),
            Doctor(
                name = "Dr. Crownover",
                photo = "",
                isFavorite = true,
                specialty = "Dentist",
                experience = "10"
            ),
            Doctor(
                name = "Dr. Balestra",
                photo = "",
                isFavorite = true,
                specialty = "Dentist",
                experience = "10"
            ),
            Doctor(
                name = "Dr. Tranquilli",
                photo = "",
                isFavorite = false,
                specialty = "Dentist",
                experience = "10"
            ),
            Doctor(
                name = "Dr. Truluck Nik",
                photo = "",
                isFavorite = false,
                specialty = "Dentist",
                experience = "10"
            ),
            Doctor(
                name = "Dr. Christenfeld N",
                photo = "",
                isFavorite = true,
                specialty = "Dentist",
                experience = "10"
            ),
        )
    }
}