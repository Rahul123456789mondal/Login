package com.example.retrofit_practice2.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val BASE_URL = "https://digitalwebgurukul.com/projects/localway/"
    private const val API_KEY: String = ""
    private val mHttpLoggingInterceptor: HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }

    private val mApiKeyInterceptor = Interceptor {
        val url = it.request().url
                .newBuilder()
                .addQueryParameter("key", API_KEY)
                .build()
        val newRequest = it.request()
                .newBuilder()
                .url(url)
                .build()
        return@Interceptor it.proceed(newRequest)
    }
    private val mOkHttpClient: OkHttpClient = OkHttpClient.Builder().apply {
        if (API_KEY.isNotEmpty()) {
            this.addInterceptor(mApiKeyInterceptor)
        }
        this.addInterceptor(mHttpLoggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
    }.build()

   /* val interceptor = HttpLoggingInterceptor()
    val client = OkHttpClient.Builder().addInterceptor(interceptor).retryOnConnectionFailure(true)
        .connectTimeout(15, TimeUnit.SECONDS)
        .build() */

    val instance: Api by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
        retrofit.create(Api::class.java)
    }
}