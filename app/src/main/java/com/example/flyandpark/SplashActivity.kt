package com.example.flyandpark

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var handler: Handler

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        initialiseView()
        animateLogo()
        goToMainActivity()

        setContentView(R.layout.activity_splash)
    }


    private fun initialiseView() {
        imageView = findViewById(R.id.imageViewLogo)
    }

    private fun animateLogo() {
        val beatLogo: Animation = AnimationUtils.loadAnimation(this, R.anim.beat)
        beatLogo.duration = 7000
        imageView.startAnimation(beatLogo)
    }

    private fun goToMainActivity() {

        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 7000)
    }

}