package com.flaviosf.digitaldoctor.common.domain.model.doctor

class Doctor(
    val name: String,
    val photo: String = "",
    val isFavorite: Boolean = false,
    val contactNumber: String = "",
    val dateOfBirth: String = "",
    val location: String = "",
    val specialty: String = "",
    val experience: String = "0",
    val schedules: List<Schedule> = listOf()
)

data class Schedule(
    val day: String,
    val month: String,
    val year: String,
    val Slots: List<Slot> = listOf()
)

data class Slot(
    val hour: String,
    val minute: String
)