package com.example.login.models.Login

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
        @SerializedName("id") val id: String,
        @SerializedName("access_token") val accessToken: String,
        @SerializedName("firstname") val firstname: String,
        @SerializedName("lastname") val lastname: String,
        @SerializedName("email") val email: String,
        @SerializedName("mobile") val mobile: String,
        @SerializedName("pincode") val pincode: String,
        @SerializedName("town_city") val townCity: String,
        @SerializedName("image") val image: String,
        @SerializedName("address") val address: String,
        @SerializedName("password") val password: String,
        @SerializedName("status") val status: String,
        @SerializedName("role_id") val roleId: String,
        @SerializedName("login_type") val loginType: String,
        @SerializedName("created_date") val createdDate: String,
        @SerializedName("updated_date") val updatedDate: String
) : Parcelable