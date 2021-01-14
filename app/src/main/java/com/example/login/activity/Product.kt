package com.example.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arka.android.androidapplication.data.model.response.product.ProductResponse
import com.example.login.R
import com.example.login.adapter.RecyclerProductAdapter
import com.example.retrofit_practice2.api.RetrofitClient
import kotlinx.android.synthetic.main.activity_product.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Product : AppCompatActivity() {

    lateinit var adapter : RecyclerProductAdapter
    //val imageUrl : String = "https://digitalwebgurukul.com/projects/localway/uploads/"+""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        RetrofitClient.instance.getAllList().enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if (response.body()!!.success) {
                    val responseBody: ProductResponse? = response.body()
                    Toast.makeText(applicationContext, "Product List Recived", Toast.LENGTH_LONG).show()
                    //Log.d("Enter the If block", responseBody.toString())

                    recyclerView.layoutManager = LinearLayoutManager(this@Product)
                    adapter = RecyclerProductAdapter(this@Product,responseBody?.data!!)
                    recyclerView.adapter = adapter

                }else {
                    Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                ProductResponse(false, null, t.message ?: "Response Failure")
                call.cancel()
            }

        })
    }

}