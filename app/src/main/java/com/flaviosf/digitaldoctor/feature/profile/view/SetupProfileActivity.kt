package com.flaviosf.digitaldoctor.feature.profile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.databinding.ActivitySetupProfileBinding

class SetupProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySetupProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetupProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load(R.drawable.onboarding_step_1_image)
            .circleCrop()
            .into(binding.profilePhoto)
    }
}