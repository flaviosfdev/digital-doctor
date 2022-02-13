package com.flaviosf.digitaldoctor.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.ui.auth.fragment.SignUpFragment
import com.flaviosf.digitaldoctor.ui.search.doctor.SearchDoctorActivity

class LoginActivity : AppCompatActivity(), ILoginCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }

    override fun goToSignUpFragment() {
        supportFragmentManager.commit {
            replace(R.id.nav_host_fragment, SignUpFragment())
            addToBackStack("signup_stack")
        }
    }

    override fun goToLoginFragment() {
        onBackPressed()
    }

    override fun goToSearchDoctorActivity() {
        startActivity(Intent(this, SearchDoctorActivity::class.java))
        finish()
    }

}