package com.example.dadok.api

import com.example.dadok.data.SearchBook
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookAPI {
    //get: 데이터 요청 시 반환 http
    //?output=json 으로 xml에서 json으로 변경
    @GET("api/search.api?output=json")
    fun getBooksByName(
        @Query("key") apikey: String,
        @Query("query") keyWord: String
    ): Call<SearchBook>
}