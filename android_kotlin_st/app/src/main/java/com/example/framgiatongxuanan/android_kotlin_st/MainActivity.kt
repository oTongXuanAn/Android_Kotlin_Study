package com.example.framgiatongxuanan.android_kotlin_st

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.function.Consumer

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var mEditUsername: EditText? = null
    var mEditPassword: EditText? = null
    lateinit var mButtonLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        handlerKotlinBase()
    }

    private fun initView() {
        mEditUsername = findViewById(R.id.edit_username)
        mEditPassword = findViewById(R.id.edit_password)
        mButtonLogin = findViewById(R.id.button_login)
        mButtonLogin.setOnClickListener(this);
    }

    private fun handlerLogin(username: String, passsword: String) {
        if (username.isEmpty()) Toast.makeText(this, "username is empty", Toast.LENGTH_LONG).show()
        else if (username == "xuanan" && passsword == "123456") {
            Toast.makeText(this, "login sucess", Toast.LENGTH_LONG).show()
            var intent: Intent = Intent(this, SettingActivity::class.java)
            intent.putExtra("username", username)
            intent.putExtra("password", passsword)
            startActivity(intent)
        } else {
            Toast.makeText(this, "login error", Toast.LENGTH_LONG).show()
        }
    }


    private fun handlerLogin2(username: String, passsword: String): Boolean {

        if (username.isEmpty()) {
            Toast.makeText(this, "username is empty", Toast.LENGTH_LONG).show()
            return false
        } else if (username == "xuanan" && passsword == "123456") {
            Toast.makeText(this, "login sucess", Toast.LENGTH_LONG).show()
            return false
        } else {
            Toast.makeText(this, "login error", Toast.LENGTH_LONG).show()
            return true
        }

    }

    override fun onClick(view: View?) {
        var username: String = mEditUsername?.text.toString();
        var password: String = mEditPassword?.text.toString();
        when (view?.id) {
            R.id.button_login -> handlerLogin(username, password);

        }

    }

    private fun handlerKotlinBase() {
        val ints: ArrayList<Int> = ArrayList();
        (1..100).forEach { i -> ints.add(i); }
        ints.forEach { n ->
            run {
                if (n == 10) {
                    Log.e("TAG", "wtf n: " + n)
                }
            }
        }

    }
}
