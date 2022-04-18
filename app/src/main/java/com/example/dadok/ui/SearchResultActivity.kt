package com.example.dadok.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dadok.R
import com.example.dadok.adapter.BookAdapter
import com.example.dadok.api.BookAPI
import com.example.dadok.data.Book
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
    private lateinit var bookAdapter: BookAdapter
    private lateinit var book: Book

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBookRecyclerView()

        initBookService()
        initSearchEditText()

    }

    // 책 API와 연결
    private fun initBookService() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://book.interpark.com/") //인터파크 베이스 주소
            .addConverterFactory(GsonConverterFactory.create()) //Gson 변환기 사용
            .build()

        bookApi = retrofit.create(BookAPI::class.java)
        binding.searchEditText.requestFocus()
        binding.totalResult.visibility = View.INVISIBLE
        binding.totalResult2.visibility = View.INVISIBLE
    }

    private fun bookServiceSearchBook(keyword: String) {

        bookApi.getBooksByName(
            getString(R.string.apiKey),
            keyword
        ).enqueue(object : Callback<SearchBook> {


            override fun onResponse(
                call: Call<SearchBook>,
                response: Response<SearchBook>

            ) {
                bookAdapter.submitList(response.body()?.books.orEmpty()) // 새 리스트로 갱신
                Log.d("books","${response.body()?.books?.size}")
                fun count(data: Int?){
                    binding.totalResult.text = data.toString()
                }
                val num = response.body()?.books?.size
                count(num)
                binding.totalResult.visibility = View.VISIBLE
                binding.totalResult2.visibility = View.VISIBLE

            }
            //실패
            override fun onFailure(call: Call<SearchBook>, t: Throwable) {
                Toast.makeText(applicationContext, "fail", Toast.LENGTH_SHORT).show()
            }

        })
    }
    @SuppressLint("ClickableViewAccessibility")
    private fun initSearchEditText() {
        binding.searchEditText.setOnKeyListener{ _, keyCode, event->
            //키보드 입력 시 발생
            //엔터 눌렀을 경우(눌렀거나, 떼었을 때 -> 눌렀을 떄 발생하도록.)
            if(keyCode == KeyEvent.KEYCODE_ENTER && event.action == MotionEvent.ACTION_DOWN) {
                bookServiceSearchBook(binding.searchEditText.text.toString())


                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }


    private fun initBookRecyclerView() {
        bookAdapter = BookAdapter(itemCLickedListener =  {
            val intent = Intent(this, BookDetailActivity::class.java)
            Log.d("bookModel","${it}")
            intent.putExtra("bookModel", it)
            startActivity(intent)
        })

        binding.searchResultRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        binding.searchResultRecycler.adapter = bookAdapter


    }



    companion object {
        private const val S_TAG = "SearchResultActivity"
    }

}