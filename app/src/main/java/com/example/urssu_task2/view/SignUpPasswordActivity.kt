package com.example.urssu_task2.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.urssu_task2.viewModel.SignUpViewModel
import com.example.urssu_task2.databinding.ActivitySignupPasswordBinding

class SignUpPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupPasswordBinding
    private val viewModel by lazy { SignUpViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        goNextScreen()
        goHomeScreen()
        deleteInput()

    }

    private fun goNextScreen() {
        binding.btnNext.setOnClickListener {
            val prefs = getSharedPreferences("my_prefs", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = prefs.edit()
            editor.putString("password", viewModel.password.value)
            editor.apply()
            startActivity(Intent(this, SignUpResultActivity::class.java))

        }
    }

    private fun goHomeScreen() {
        binding.ivCancel.setOnClickListener {
            startActivity(Intent(this, SignUpEmailActivity::class.java))
        }
    }

    private fun deleteInput(){
        val textInputLayout = binding.layoutPassword
        textInputLayout.setEndIconOnClickListener{
            binding.password.setText("")
        }
    }

}