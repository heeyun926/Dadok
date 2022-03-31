package com.example.dadok.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.Toast
import com.example.dadok.R
import com.example.dadok.api.NaverAPI
import com.example.dadok.data.BookAPI
import com.example.dadok.databinding.ActivitySearchResultBinding

class SearchResultActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySearchResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_search_result)

        initSearchEditText()
    }

    fun SearchResultBook(keyword: String){
        BookAPI.getBookByName()

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initSearchEditText(){
        binding.searchBook.setOnKeyListener{ v, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_ENTER && event.action == MotionEvent.ACTION_DOWN){
                SearchResultBook(binding.searchBook.text.toString())
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
        binding.searchBook.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                Toast.makeText(this@SearchResultActivity, "nope", Toast.LENGTH_SHORT).show()
            }
            return@setOnTouchListener false
        }
    }

    companion object {
        private const val M_TAG = "MainActivity"
    }
}