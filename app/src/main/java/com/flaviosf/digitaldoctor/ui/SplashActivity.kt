package com.flaviosf.digitaldoctor.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.ui.onboarding.OnboardingActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var logoAnimated: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        logoAnimated = findViewById(R.id.progress_bar)

        Glide.with(logoAnimated)
            .load(R.drawable.logo_animated)
            .apply(RequestOptions().override(72,72))
            .into(logoAnimated)

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, OnboardingActivity::class.java))
            finish()
        }, 3000)

    }
}