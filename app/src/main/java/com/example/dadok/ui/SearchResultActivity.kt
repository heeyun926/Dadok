package com.example.dadok.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dadok.R
import com.example.dadok.api.BookAPI
import com.example.dadok.data.SearchBook
import com.example.dadok.databinding.ActivitySearchResultBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchResultActivity : AppCompatActivity() {
    private lateinit var bookApi: BookAPI
    private lateinit var binding: ActivitySearchResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_search_result)

        initBookService()
    }

    // 책 API와 연결
    private fun initBookService() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://book.interpark.com/") //인터파크 베이스 주소
            .addConverterFactory(GsonConverterFactory.create()) //Gson 변환기 사용
            .build()

        bookApi = retrofit.create(BookAPI::class.java)
    }

    fun bookServiceSearchBook(keyword: String) {

        bookApi.getBooksByName(
            getString(R.string.apiKey),
            keyword
        ).enqueue(object : Callback<SearchBook> {


            override fun onResponse(
                call: Call<SearchBook>,
                response: Response<SearchBook>
            ) {
                //함수 공간
                if(response.isSuccessful.not()) {
                    return
                }


            }

            override fun onFailure(call: Call<SearchBook>, t: Throwable) {

            }

        })
    }

}