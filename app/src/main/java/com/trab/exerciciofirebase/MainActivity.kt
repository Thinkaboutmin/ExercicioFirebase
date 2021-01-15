package com.trab.exerciciofirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.trab.exerciciofirebase.databinding.ActivityLoginctivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginctivityBinding

    private val viewModel by viewModels<LoginViewModel> {
        LoginViewModel.getFactory(
            FirebaseAuth.getInstance()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginctivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)

        val bodyBinding = binding.include2

        bodyBinding.run {
            btnLogin.setOnClickListener {
                val email = bodyBinding.edUserName.text.toString()
                val password = bodyBinding.edPassword.text.toString()

                val user = User(email, password)

                viewModel.login(user)
            }

            tvRegister.setOnClickListener {
                val intent = Intent(this@MainActivity,  RegisterActivity::class.java)
                startActivity(intent)
            }
        }

    }
}