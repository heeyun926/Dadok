package com.example.dadok.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultGetBook(
    //Img, Title, Author, Publisher

    //TODO Parcelize와 SerializedName 왜 쓰는지 알아 보기!
    //Request
    @SerializedName("d_title") var d_title: String = "",
    @SerializedName("d_author")var d_auth: String = "",
    //Result
    @SerializedName("img")var image: String = "",
    @SerializedName("title")var title: String = "",
    @SerializedName("author")var author: String = "",
    @SerializedName("publisher")var publisher: String = ""
//TODO - var items: List<Items> 이걸 쓰는 게 좋을까?
) : Parcelable

