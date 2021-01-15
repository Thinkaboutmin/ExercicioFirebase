package com.trab.exerciciofirebase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginViewModel(private val firebaseAuth: FirebaseAuth) : ViewModel() {

    val statusLogin = MutableLiveData<Int>()

    fun login(user: User) {
        firebaseAuth.signInWithEmailAndPassword(user.email, user.password).addOnCompleteListener {
            Log.e("OK", "AAA")
        }.addOnCanceledListener {
            Log.e("EXPLODIU", "AAA")
        }.addOnFailureListener {
            Log.e("EXPLODIU", "AAA")
        }
    }

    companion object {
        fun getFactory(firebaseAuth: FirebaseAuth) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return modelClass.getConstructor(FirebaseAuth::class.java).newInstance(firebaseAuth)
            }
        }
    }
}