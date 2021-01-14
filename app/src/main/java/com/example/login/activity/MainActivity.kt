package com.example.login.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.login.R
import com.example.login.models.Login.LoginRespose
import com.example.retrofit_practice2.api.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin.setOnClickListener {
            val mobile = editTextMobile.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if(mobile.isEmpty()){
                editTextMobile.error = "Mobile required"
                editTextMobile.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty()){
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.userLogin(mobile, password)
                .enqueue(object : Callback<LoginRespose> {
                    override fun onFailure(call: Call<LoginRespose>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        Log.d("Fail", t.message.toString())
                    }

                    override fun onResponse(call: Call<LoginRespose>, response: Response<LoginRespose>) {

                        if (response.body()?.status!!) {
                            Log.d("Sucess", response.toString())
                            val intent = Intent(applicationContext, Product::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                            startActivity(intent)

                        } else {
                            Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                        }

                    }
                })

        }
    }
}