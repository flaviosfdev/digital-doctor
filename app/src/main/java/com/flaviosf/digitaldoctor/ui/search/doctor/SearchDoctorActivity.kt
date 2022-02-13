package com.flaviosf.digitaldoctor.ui.search.doctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.flaviosf.digitaldoctor.R

class SearchDoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_doctor)
        supportFragmentManager.findFragmentById(R.id.search_doctor_nav_host_fragment) as NavHostFragment
    }
}