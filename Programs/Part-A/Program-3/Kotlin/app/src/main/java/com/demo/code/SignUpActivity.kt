package com.demo.code

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.demo.code.databinding.ActivityLogInBinding
import com.demo.code.databinding.ActivitySignUpBinding
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.signUpId.setOnClickListener { v: View? ->
            val userName = binding.usrNameId.text.toString()
            val inputPwd = binding.pwdId.text.toString()
            if (validatePassword(inputPwd) && validateUserName(userName)) {
                val bundle = Bundle()
                bundle.putString("userName", userName)
                bundle.putString("password", inputPwd)
                val intent = Intent(this@SignUpActivity, LogInActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    /*
      Password should contain uppercase and lowercase letters.
      Password should contain letters and numbers.
      Password should contain special characters.
      Minimum length of the password (the default value is 8).*/
    private fun validatePassword(inputPwd: String): Boolean {
        val regexValidation = ("^(?=.*[a-z])(?=."
                + "*[A-Z])(?=.*\\d)"
                + "(?=.*[-+_!@#$%^&*., ?]).+$")
        val p = Pattern.compile(regexValidation)
        val m = p.matcher(inputPwd)
        return if (m.matches() && inputPwd.length >= 8) {
            true
        } else {
            Toast.makeText(this@SignUpActivity, "Enter Valid Password", Toast.LENGTH_SHORT).show()
            false
        }
    }

    /**
     * Check if the user has entered a user name
     */
    private fun validateUserName(userName: String): Boolean {
        return userName.isNotEmpty()
    }

}