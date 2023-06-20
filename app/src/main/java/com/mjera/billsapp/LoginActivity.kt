package com.mjera.billsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mjera.billsapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume(){
        super.onResume()
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            clearErrors()
            validateSignUp()
        }
    }
    fun validateSignUp() {

        val email = binding.etEmail.text.toString()
        var error=false
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
        }

    }
    fun clearErrors() {
        binding.tilEmail.error = null
    }
}