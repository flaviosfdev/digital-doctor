package com.flaviosf.digitaldoctor.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.flaviosf.digitaldoctor.R
import com.flaviosf.digitaldoctor.ui.auth.LoginActivity
import com.flaviosf.digitaldoctor.ui.onboarding.fragment.OnboardingStep1Fragment
import com.flaviosf.digitaldoctor.ui.onboarding.fragment.OnboardingStep2Fragment
import com.flaviosf.digitaldoctor.ui.onboarding.fragment.OnboardingStep3Fragment
import com.google.android.material.button.MaterialButton

class OnboardingActivity : AppCompatActivity() {

    private val onboardingViewPager: ViewPager2
        get() = findViewById(R.id.onboarding_view_pager)
    private val onboardingNextButton: MaterialButton
        get() = findViewById(R.id.onboarding_next_button)
    private val onboardingSkipButton: MaterialButton
        get() = findViewById(R.id.onboarding_skip_button)
    private val onboardingSteps = listOf(
        OnboardingStep1Fragment(),
        OnboardingStep2Fragment(),
        OnboardingStep3Fragment(),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        setupViewPager()

        onboardingNextButton.setOnClickListener {
            if (onboardingNextButton.text.toString() == getString(R.string.onboarding_button_get_started)) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                onboardingViewPager.currentItem++
            }
        }

        onboardingSkipButton.setOnClickListener {
            onboardingViewPager.currentItem = onboardingSteps.size - 1
        }
    }

    private fun setupViewPager() {
        onboardingViewPager.adapter = OnboardingAdapter(this, onboardingSteps)
        onboardingViewPager.isUserInputEnabled = false

        onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                onboardingNextButton.text = getString(R.string.onboarding_button_next)
                when (position) {
                    2 -> {
                        onboardingNextButton.text =
                            getString(R.string.onboarding_button_get_started)
                        onboardingSkipButton.visibility = View.INVISIBLE
                    }
                }
            }
        })
    }

    override fun onBackPressed() {
        if (onboardingViewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            onboardingViewPager.currentItem -= 1
            onboardingSkipButton.visibility = View.VISIBLE
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