package com.example.dadok.data

import com.google.gson.annotations.SerializedName

data class SearchBook(
    @SerializedName("title") val title: String,
    @SerializedName("item") val books: List<Book>
)
