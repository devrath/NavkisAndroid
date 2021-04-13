package com.demo.code;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {

    private String userName,password;

    private EditText usrNameId;
    private EditText pwdId;
    private Button loginId;

    private int attemptCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        findViewsForTheScreen();
        getDataFromPreviousScreen();
        setOnClickListener();
    }

    private void setOnClickListener() {


        loginId.setOnClickListener(v -> {
            attemptCounter++;
            String loginUserName = usrNameId.getText().toString();
            String loginPassword = pwdId.getText().toString();
            if(attemptLogin(loginUserName,loginPassword)){
                //Navigate to success activity
                Intent intent = new Intent(LogInActivity.this, SuccessActivity.class);
                startActivity(intent);
            }else{
                if(attemptCounter>=2){
                    // Disable the Login Button
                    loginId.setEnabled(false);
                }
            }
        });
    }

    private boolean attemptLogin(String loginUserName, String loginPassword) {

        if(userName.equals(loginUserName) && password.equals(loginPassword)){
            return true;
        }else{
            Toast.makeText(LogInActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private void getDataFromPreviousScreen() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            userName = bundle.getString("userName");
            password = bundle.getString("password");
        }
    }

    /**
     * Find the objects for the screen
     */
    private void findViewsForTheScreen() {
        usrNameId = findViewById(R.id.usrNameId);
        pwdId = findViewById(R.id.pwdId);
        loginId = findViewById(R.id.loginId);
    }

}