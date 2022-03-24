package com.flaviosf.digitaldoctor.feature.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.databinding.ActivitySplashBinding
import com.flaviosf.digitaldoctor.feature.onboarding.view.OnboardingActivity

class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Glide.with(binding.root)
            .load(R.drawable.loading)
            .apply(RequestOptions().override(72,72))
            .into(binding.progressBar)

        // VERIFICAR DOC PARA FAZER DA MANEIRA NOVA
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, OnboardingActivity::class.java))
            finish()
        }, 3000)

    }
}