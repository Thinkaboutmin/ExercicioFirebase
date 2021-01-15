package com.trab.exerciciofirebase

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.trab.exerciciofirebase.databinding.ActivityRegisterBinding

class RegisterActivity: AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val viewModel by viewModels<RegisterViewModel> {
        RegisterViewModel.getFactory(FirebaseAuth.getInstance())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bodyBinding = binding.include2
        bodyBinding.run {
            btnRegister.setOnClickListener {
                val email = edUserEmailRegister.text.toString()
                val password = edUserPasswordRegister.text.toString()

                val user = User(email, password)
                viewModel.register(user)
            }

            viewModel.statusCreation.observe(this@RegisterActivity) {
                // TODO
            }
        }
    }
}