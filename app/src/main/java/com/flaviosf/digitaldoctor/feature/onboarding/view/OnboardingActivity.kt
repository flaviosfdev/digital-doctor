package com.flaviosf.digitaldoctor.feature.onboarding.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.databinding.ActivityOnboardingBinding
import com.flaviosf.digitaldoctor.feature.auth.view.AuthActivity
import com.flaviosf.digitaldoctor.feature.onboarding.view.fragment.OnboardingStep1Fragment
import com.flaviosf.digitaldoctor.feature.onboarding.view.fragment.OnboardingStep2Fragment
import com.flaviosf.digitaldoctor.feature.onboarding.view.fragment.OnboardingStep3Fragment

class OnboardingActivity : AppCompatActivity() {

    private val binding: ActivityOnboardingBinding by lazy {
        ActivityOnboardingBinding.inflate(layoutInflater)
    }
    private val onboardingSteps = listOf(
        OnboardingStep1Fragment(),
        OnboardingStep2Fragment(),
        OnboardingStep3Fragment(),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViewPager()

        binding.onboardingNextButton.setOnClickListener {
            if (binding.onboardingNextButton.text.toString() == getString(R.string.onboarding_button_get_started)) {
                val intent = Intent(this, AuthActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                binding.onboardingViewPager.currentItem++
            }
        }

        binding.onboardingSkipButton.setOnClickListener {
            binding.onboardingViewPager.currentItem = onboardingSteps.size - 1
        }
    }

    private fun setupViewPager() {
        with(binding) {
            onboardingViewPager.apply {
                adapter = OnboardingAdapter(this@OnboardingActivity, onboardingSteps)
                isUserInputEnabled = false

                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        binding.onboardingNextButton.text =
                            getString(R.string.onboarding_button_next)
                        when (position) {
                            2 -> {
                                with(binding) {
                                    onboardingNextButton.text =
                                        getString(R.string.onboarding_button_get_started)
                                    onboardingSkipButton.visibility = View.INVISIBLE
                                }
                            }
                        }
                    }
                })
            }
        }
    }

    override fun onBackPressed() {
        if (binding.onboardingViewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            with(binding) {
                onboardingViewPager.currentItem -= 1
                onboardingSkipButton.visibility = View.VISIBLE
            }
        }
    }

    private inner class OnboardingAdapter(
        fragmentManager: FragmentActivity,
        private val steps: List<Fragment>
    ) : FragmentStateAdapter(fragmentManager) {

        override fun getItemCount(): Int = steps.size

        override fun createFragment(position: Int): Fragment = steps[position]
    }
}