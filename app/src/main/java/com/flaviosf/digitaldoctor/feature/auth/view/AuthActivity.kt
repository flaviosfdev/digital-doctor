package com.flaviosf.digitaldoctor.feature.auth.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import com.flaviosf.digitaldoctor.feature.auth.view.fragment.AuthStepSignUpFragment
import com.flaviosf.digitaldoctor.databinding.ActivityAuthBinding
import com.flaviosf.digitaldoctor.feature.doctor.view.DoctorActivity

class AuthActivity : AppCompatActivity(), IAuthCallbacks {

    private val binding: ActivityAuthBinding by lazy { ActivityAuthBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
    }

    override fun goToSignUpFragment() {
        supportFragmentManager.commit {
            replace(binding.navHostFragment.id, AuthStepSignUpFragment())
            addToBackStack("signup_stack")
        }
    }

    override fun goToLoginFragment() {
        onBackPressed()
    }

    override fun goToSearchDoctorActivity() {
        startActivity(Intent(this, DoctorActivity::class.java))
        finish()
    }

}