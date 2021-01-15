package com.trab.exerciciofirebase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel(private val firebaseAuth: FirebaseAuth): ViewModel() {
    val statusCreation = MutableLiveData<Int>()

    fun register(user: User) {
        firebaseAuth.createUserWithEmailAndPassword(user.email, user.password)
        .addOnCanceledListener {
            Log.e("EXPLODIU", "AAA")
        }.addOnFailureListener {
            Log.e("EXPLODIU", it.message!!)
        }.addOnSuccessListener {
                Log.e("EXPLODIU", "aaa")
        }
    }

    companion object {
        fun getFactory(firebaseAuth: FirebaseAuth) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                modelClass.getConstructor(FirebaseAuth::class.java).newInstance(firebaseAuth)
        }
    }
}