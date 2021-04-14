package com.demo.code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputFieldId;
    private Button numZeroId,numOneId,numTwoId,numThreeId,numFourId,numFiveId,numSixId,numSevenId,numEightId,numNineId;
    private Button delId,starId,hashId,callId,saveId;

    private boolean isCallOperation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsForTheScreen();
        setOnclickListeners();
    }

    private void findViewsForTheScreen() {
        // Numbers
        inputFieldId = findViewById(R.id.inputFieldId);
        numZeroId = findViewById(R.id.numZeroId);
        numOneId = findViewById(R.id.numOneId);
        numTwoId = findViewById(R.id.numTwoId);
        numThreeId = findViewById(R.id.numThreeId);
        numFourId = findViewById(R.id.numFourId);
        numFiveId = findViewById(R.id.numFiveId);
        numSixId = findViewById(R.id.numSixId);
        numSevenId = findViewById(R.id.numSevenId);
        numEightId = findViewById(R.id.numEightId);
        numNineId = findViewById(R.id.numNineId);

        delId = findViewById(R.id.delId);
        starId = findViewById(R.id.starId);
        hashId = findViewById(R.id.hashId);
        callId = findViewById(R.id.callId);
        saveId = findViewById(R.id.saveId);
    }

    private void setOnclickListeners() {

        delId.setOnClickListener(view -> {
            int length = inputFieldId.getText().length();
            if (length > 0) {
                inputFieldId.getText().delete(length - 1, length);
            }
        });

        callId.setOnClickListener(view -> {
            isCallOperation = true;
            // Call operation
            if(isPermissionGranted()){
                callAction();
            }
        });

        saveId.setOnClickListener(view -> {
            isCallOperation = false;
            // Save operation
            if(isPermissionGranted()){
                callAction();
            }
        });

        starId.setOnClickListener(view -> {
            // Star
            inputFieldId.append("*");
        });

        hashId.setOnClickListener(view -> {
            // Hash
            inputFieldId.append("#");
        });

        numZeroId.setOnClickListener(view -> {
            // Button Number Zero
            inputFieldId.append("0");
        });

        numOneId.setOnClickListener(view -> {
            // Button Number One
            inputFieldId.append("1");
        });

        numTwoId.setOnClickListener(view -> {
            // Button Number Two
            inputFieldId.append("2");
        });

        numThreeId.setOnClickListener(view -> {
            // Button Number Three
            inputFieldId.append("3");
        });

        numFourId.setOnClickListener(view -> {
            // Button Number Four
            inputFieldId.append("4");
        });

        numFiveId.setOnClickListener(view -> {
            // Button Number Five
            inputFieldId.append("5");
        });

        numSixId.setOnClickListener(view -> {
            // Button Number Six
            inputFieldId.append("6");
        });

        numSevenId.setOnClickListener(view -> {
            // Button Number Seven
            inputFieldId.append("7");
        });

        numEightId.setOnClickListener(view -> {
            // Button Number Eight
            inputFieldId.append("8");
        });

        numNineId.setOnClickListener(view -> {
            // Button Number Nine
            inputFieldId.append("9");
        });

    }

    private boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                callAction();
            } else {
                Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void callAction() {
        String number=inputFieldId.getText().toString().trim();
        if(isCallOperation){
            // Call the Number
            String no="tel:"+number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(no)));
        }else{
            // Save the number
            Intent contactIntent = new Intent(ContactsContract.Intents.Insert. ACTION ) ;
            contactIntent.setType(ContactsContract.RawContacts. CONTENT_TYPE ) ;
            contactIntent.putExtra(ContactsContract.Intents.Insert. PHONE , number) ;
            startActivityForResult(contactIntent , 1 ) ;
        }
    }

    @Override
    protected void onActivityResult ( int requestCode , int resultCode , Intent intent) {
        super .onActivityResult(requestCode , resultCode , intent) ;
        if (requestCode == 1 ) {
            if (resultCode == Activity. RESULT_OK ) {
                Toast. makeText ( this, "Added Contact" , Toast. LENGTH_SHORT ).show() ;
            }
            if (resultCode == Activity. RESULT_CANCELED ) {
                Toast. makeText ( this, "Cancelled Added Contact" ,
                        Toast. LENGTH_SHORT ).show() ;
            }
        }
    }

}