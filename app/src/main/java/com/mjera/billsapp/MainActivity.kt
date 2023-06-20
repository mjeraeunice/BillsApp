package com.mjera.billsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mjera.billsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener {
            clearErrors()
            validateSignUp()
        }
    }

    fun validateSignUp() {
        val username=binding.etUsername.text.toString()
        val pnumber=binding.etPhonenumber.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        var error = false

        if (username.isBlank()) {
            binding.tilUsername.error = "First name is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmailaddress.error = "Email is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }
        if (pnumber.isBlank()) {
            binding.tilPhonenumber.error = "Your phone number is required"
            error = true
        }
       if(!error){
            Toast.makeText(this,"Registration of $username was sucessful",
            Toast.LENGTH_LONG).show()
       }
    }

    fun clearErrors() {
        binding.tilUsername.error = null
        binding.tilEmailaddress.error = null
        binding.tilPassword.error = null
        binding.tilPhonenumber.error = null
    }
}