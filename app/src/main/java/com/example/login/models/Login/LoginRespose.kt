package com.example.login.models.Login

import android.os.Parcelable
import com.example.login.models.Login.Data
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginRespose(
        @SerializedName("status") val status: Boolean,
        @SerializedName("data") val `data`: List<Data>?,
        @SerializedName("message") val message: String
) : Parcelable