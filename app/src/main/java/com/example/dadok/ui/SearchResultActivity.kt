package com.example.dadok.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dadok.R
import com.example.dadok.databinding.ActivitySearchResultBinding

class SearchResultActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySearchResultBinding
    val clientId = "d3r1rCCiCGEVqC3Cou6Y"
    val clientSecret = "A4J2Bg1rZc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_search_result)

        initSearchEditText()
    }
    private fun initSearchEditText(){
        binding.textView4
    }
}