package com.demo.code

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.demo.code.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isCallOperation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnclickListeners()
    }

    private fun setOnclickListeners() {
        binding.apply {
            delId.setOnClickListener {
                val length = inputFieldId.text.length
                if (length > 0) {
                    inputFieldId.text.delete(length - 1, length)
                }
            }
            callId.setOnClickListener {
                isCallOperation = true
                // Call operation
                if (isPermissionGranted) {
                    callAction()
                }
            }
            saveId.setOnClickListener {
                isCallOperation = false
                // Save operation
                if (isPermissionGranted) {
                    callAction()
                }
            }
            starId.setOnClickListener { inputFieldId.append("*") }
            hashId.setOnClickListener { inputFieldId.append("#") }
            numZeroId.setOnClickListener { inputFieldId.append("0") }
            numOneId.setOnClickListener { inputFieldId.append("1") }
            numTwoId.setOnClickListener { inputFieldId.append("2") }
            numThreeId.setOnClickListener { inputFieldId.append("3") }
            numFourId.setOnClickListener { inputFieldId.append("4") }
            numFiveId.setOnClickListener { inputFieldId.append("5") }
            numSixId.setOnClickListener { inputFieldId.append("6") }
            numSevenId.setOnClickListener { inputFieldId.append("7")}
            numEightId.setOnClickListener {inputFieldId.append("8") }
            numNineId.setOnClickListener { inputFieldId.append("9") }
        }
    }

    //permission is automatically granted on sdk<23 upon installation
    private val isPermissionGranted: Boolean
        get() = if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG", "Permission is granted")
                true
            } else {
                Log.v("TAG", "Permission is revoked")
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 1)
                false
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG", "Permission is granted")
            true
        }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(applicationContext, "Permission granted", Toast.LENGTH_SHORT).show()
                callAction()
            } else {
                Toast.makeText(applicationContext, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun callAction() {
        val number = binding.inputFieldId!!.text.toString().trim { it <= ' ' }
        if (isCallOperation) {
            // Call the Number
            val no = "tel:$number"
            startActivity(Intent(Intent.ACTION_CALL, Uri.parse(no)))
        } else {
            // Save the number
            val contactIntent = Intent(ContactsContract.Intents.Insert.ACTION)
            contactIntent.type = ContactsContract.RawContacts.CONTENT_TYPE
            contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, number)
            startActivityForResult(contactIntent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Added Contact", Toast.LENGTH_SHORT).show()
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled Added Contact",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }
}