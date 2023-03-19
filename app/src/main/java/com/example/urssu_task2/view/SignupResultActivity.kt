package com.example.urssu_task2.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.urssu_task2.databinding.ActivitySignupResultBinding

class SignupResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        goHomeScreen()
    }

    private fun goHomeScreen() {
        binding.ivCancel.setOnClickListener {
            startActivity(Intent(this, SignUpEmailActivity::class.java))
        }
    }

    private fun loadData() {
        val prefs = getSharedPreferences("my_prefs", MODE_PRIVATE)
        val email = prefs.getString("email", null)
        val password = prefs.getString("password", null)
        binding.tvEmail.text = "email: ${email}@soongsil.ac.kr"
        binding.tvPassword.text = "password: $password"

    }
}