package com.example.pulsebuttonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var handlerAnimation = Handler()
    private var statusAnimation = false
    private var runnable = object : Runnable {
        override fun run() {

            pulse1.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(1000)
                .withEndAction {
                    pulse1.scaleX = 0.01f
                    pulse1.scaleY = 0.01f
                    pulse1.alpha = 1f
                }

            pulse2.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(1000)
                .withEndAction {
                    pulse2.scaleX = 0.01f
                    pulse2.scaleY = 0.01f
                    pulse2.alpha = 1f
                }

            handlerAnimation.postDelayed(this, 1500)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            if(statusAnimation) {
                stopPulse()
            } else {
                startPulse()
            }
            statusAnimation = !statusAnimation
        }
    }

    private fun startPulse() {
        runnable.run()
    }

    private fun stopPulse() {
        handlerAnimation.removeCallbacks(runnable)
    }
}
