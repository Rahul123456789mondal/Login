package com.arka.android.androidapplication.data.model.response.product


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
@Keep
data class ProductResponse(
    @SerializedName("status") val success: Boolean,
    @SerializedName("data") val `data`: List<ProductResponseData>?,
    @SerializedName("message") val message: String?
) : Parcelable