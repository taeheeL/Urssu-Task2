package com.example.urssu_task2.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.urssu_task2.viewModel.SignUpViewModel
import com.example.urssu_task2.databinding.ActivitySignupEmailBinding

class SignUpEmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupEmailBinding
    private val viewModel by viewModels<SignUpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        goNextScreen()
    }

    private fun goNextScreen() {
        binding.btnNext.setOnClickListener {
            val prefs = getSharedPreferences("my_prefs", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = prefs.edit()
            editor.putString("email", viewModel.email.value)
            editor.apply()
            startActivity(Intent(this, SignUpPasswordActivity::class.java))
        }
    }


}