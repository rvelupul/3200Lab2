package com.example.k2023_01_19b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding
import androidx.viewbinding.ViewBindings
import com.example.k2023_01_19b.databinding.ActivitySplashPageBinding

class SplashPage : AppCompatActivity() {

    private lateinit var binding: ActivitySplashPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_splash_page)

        binding = ActivitySplashPageBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.launchButton.setOnClickListener(
            View.OnClickListener {
                Intent(this,MainActivity::class.java).also{
                    it -> startActivity(it)
                }

            }
        )

    }
}