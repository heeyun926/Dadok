package com.example.dadok.api

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverAPI {
    @GET("https://openapi.naver.com/v1/search/book.json")
    fun getBookList(
        @Header() clientId: String,
        @Header() clientSecret: String,
        @Query() query: String
    )
}