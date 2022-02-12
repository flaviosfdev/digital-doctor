package com.flaviosf.digitaldoctor.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.ui.auth.fragment.SignUpFragment

class LoginActivity : AppCompatActivity(), ILoginCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
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

}