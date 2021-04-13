package com.demo.code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    private EditText usrNameId;
    private EditText pwdId;
    private Button signUpId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findViewsForTheScreen();
        setOnClickListener();
    }

    private void setOnClickListener() {
        signUpId.setOnClickListener(v -> {

            String userName = usrNameId.getText().toString();
            String inputPwd = pwdId.getText().toString();

           if(validatePassword(inputPwd) && validateUserName(userName)){

               Bundle bundle = new Bundle();
               bundle.putString("userName",userName);
               bundle.putString("password",inputPwd);
               Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
               intent.putExtras(bundle);
               startActivity(intent);

           }
        });
    }

    /*
      Password should contain uppercase and lowercase letters.
      Password should contain letters and numbers.
      Password should contain special characters.
      Minimum length of the password (the default value is 8).*/
    private boolean validatePassword(String inputPwd) {

        String regexValidation = "^(?=.*[a-z])(?=."
                                + "*[A-Z])(?=.*\\d)"
                                + "(?=.*[-+_!@#$%^&*., ?]).+$";

        Pattern p = Pattern.compile(regexValidation);
        Matcher m = p.matcher(inputPwd);

        if(m.matches() && inputPwd.length()>=8){
            return true;
        }else{
            Toast.makeText(SignUpActivity.this,"Enter Valid Password",Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    /**
     * Check if the user has entered a user name
     */
    private boolean validateUserName(String userName) {
        return userName.length() > 0;
    }

    /**
     * Find the objects for the screen
     */
    private void findViewsForTheScreen() {
        usrNameId = findViewById(R.id.usrNameId);
        pwdId = findViewById(R.id.pwdId);
        signUpId = findViewById(R.id.signUpId);
    }


}