package com.arka.android.androidapplication.data.model.response.product


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
@Keep
data class ProductResponseData(
    @SerializedName("cat_name") val catName: String,
    @SerializedName("sub_cat_name") val subCatName: String,
    @SerializedName("cat_id") val catId: String,
    @SerializedName("sub_cat_id") val subCatId: String,
    @SerializedName("product_id") val productId: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("qty") val qty: String,
    @SerializedName("price") val price: String,
    @SerializedName("offer_price") val offerPrice: String,
    @SerializedName("measurement") val measurement: String,
    @SerializedName("image") val image: String,
    @SerializedName("image_1") val image1: String,
    @SerializedName("image_2") val image2: String,
    @SerializedName("image_3") val image3: String,
    @SerializedName("delivery_charge") val deliveryCharge: String,
    @SerializedName("product_status") val productStatus: String,
    @SerializedName("status") val status: String,
    @SerializedName("created_date") val createdDate: String,
    @SerializedName("disclaimer") val disclaimer: String,
    @SerializedName("key_features") val keyFeatures: String
) : Parcelable