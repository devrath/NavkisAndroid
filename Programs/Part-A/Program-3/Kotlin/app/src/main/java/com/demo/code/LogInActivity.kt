package com.demo.code

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.demo.code.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {

    private var attemptCounter = 0
    private lateinit var binding: ActivityLogInBinding

    private var userName: String = ""
    private var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataFromPreviousScreen()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.loginId.setOnClickListener {
            attemptCounter++
            val loginUserName = binding.usrNameId.text.toString()
            val loginPassword = binding.pwdId.text.toString()
            if (attemptLogin(loginUserName, loginPassword)) {
                //Navigate to success activity
                val intent = Intent(this@LogInActivity, SuccessActivity::class.java)
                startActivity(intent)
            } else {
                if (attemptCounter >= 2) {
                    // Disable the Login Button
                    binding.loginId.isEnabled = false
                }
            }
        }
    }

    private fun attemptLogin(loginUserName: String, loginPassword: String): Boolean {
        return if (userName == loginUserName && password == loginPassword) {
            true
        } else {
            Toast.makeText(this@LogInActivity, "Login Failed", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun dataFromPreviousScreen() {
        val bundle = intent.extras
        if (bundle != null) {
            userName = bundle.getString("userName").toString()
            password = bundle.getString("password").toString()
        }
     }

}