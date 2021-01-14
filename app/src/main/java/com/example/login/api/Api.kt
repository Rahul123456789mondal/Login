package com.example.retrofit_practice2.api

import com.arka.android.androidapplication.data.model.response.product.ProductResponse
import com.example.login.models.Login.LoginRespose
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("customer-login")
    fun userLogin(
        @Field("mobile") email:String,
        @Field("password") password: String
    ):Call<LoginRespose>


    @POST("all-product")
    fun getAllList() : Call<ProductResponse>

}