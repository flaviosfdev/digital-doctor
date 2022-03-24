package com.flaviosf.digitaldoctor.feature.doctor.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.flaviosf.digitaldoctor.databinding.ActivityDoctorBinding

class DoctorActivity : AppCompatActivity() {

    private val binding: ActivityDoctorBinding by lazy {
        ActivityDoctorBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.findFragmentById(binding.doctorNavHostFragment.id) as NavHostFragment
    }
}