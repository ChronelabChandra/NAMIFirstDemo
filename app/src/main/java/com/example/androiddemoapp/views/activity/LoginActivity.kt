package com.example.androiddemoapp.views.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.androiddemoapp.R

class LoginActivity : AppCompatActivity() {
    var TAG = "MainActivity"
    lateinit var txtUserName: EditText
    lateinit var txtPassword: EditText
    lateinit var btnLogin: Button

    fun btnSubmitAction() {
//        val user = User()
//        user.firstName = this.txtFirstName.text.toString()
//        user.middleName = this.txtMiddleName.text.toString()
//        user.lastName = this.txtLastName.text.toString()

        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra(INTENT_KEY_USER, user)
//
        startActivity(intent)
//        finish()


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtUserName = findViewById(R.id.txt_username)
        txtPassword = findViewById(R.id.txt_password)
        btnLogin = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener {
            btnSubmitAction()
        }
    }
}