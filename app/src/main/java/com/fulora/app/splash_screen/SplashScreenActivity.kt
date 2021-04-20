package com.fulora.app.splash_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fulora.app.MainActivity
import com.fulora.app.R
import com.fulora.app.databinding.ActivitySplashScreenBinding
import com.fulora.app.onboarding.OnboardingActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    private val activityScope = CoroutineScope(Dispatchers.Main)
    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)

        val myBoolean = false //TODO: Fazer para verificar se o cara está logado

        activityScope.launch {
            delay(1000)
            if (myBoolean) {
                startActivity(MainActivity.createIntent(this@SplashScreenActivity))
            } else {
                startActivity(OnboardingActivity.createIntent(this@SplashScreenActivity))
            }

            finish()
        }
    }
}