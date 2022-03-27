package com.example.dadok.api

import com.example.dadok.data.ResultGetBook
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverAPI {
    @GET("https://openapi.naver.com/v1/search/book.json")
    fun getBookList(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientSecret: String,
        @Query("query") query: String,
        @Query("display") display: Int? = null,
        @Query("start") start: Int? = null
    ): Call<ResultGetBook>

    //Retrrofit과 OkHttp를 함께 쓰는 방법
    //Activity가 아닌 Interface에서 생성함으로써 Activity마다 Retrofit객체 생성을 하지 않게끔!
    companion object {
        private const val BASE_URL_NAVER_API = "https://openapi.naver.com/v1/search/book.json"
        private const val CLIENT_ID = "d3r1rCCiCGEVqC3Cou6Y"
        private const val CLIENT_SECRET = "A4J2Bg1rZc"

        fun create(): NaverAPI {

            val httpLoggingInterceptor = HttpLoggingInterceptor()





            return Retrofit.Builder()
                .baseUrl(BASE_URL_NAVER_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NaverAPI::class.java)
        }
    }
}