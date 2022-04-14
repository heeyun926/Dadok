package com.example.dadok.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book(
    @SerializedName("itemId") val id: Long = 0,
    @SerializedName("title") val title: String = "",
    @SerializedName("author") val author: String = "",
    @SerializedName("publisher") val publisher: String = "",
    @SerializedName("totalResults") val result: Int = 0,
    //img
    @SerializedName("coverSmallUrl") val coverSmallUrl: String = "",
    @SerializedName("coverLargeUrl") val coverLargeUrl: String = "",
    //In Detail
    @SerializedName("description") val description: String = "",
    @SerializedName("categoryName") val categoryName: String = "",
    @SerializedName("priceSales") val priceSales: Long = 0
): Parcelable
