package com.example.dadok.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.dadok.R
import com.example.dadok.data.Book
import com.example.dadok.databinding.ActivityBookDetailBinding
import java.io.Serializable

class BookDetailActivity : AppCompatActivity(),Serializable {

    private lateinit var binding: ActivityBookDetailBinding
    private lateinit var book: Book

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBookDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        if (intent.getSerializableExtra("data") != null) {
            book = intent.getSerializableExtra("data") as Book

            Glide.with(this).load(book.coverSmallUrl).into(binding.mainImg)
            Glide.with(this).load(book.coverLargeUrl).into(binding.mainImg)
            binding.title.text = book.title
            binding.author.text = book.author
            binding.publisher.text = book.publisher
            binding.category.text = book.categoryName
            //binding.sales.setInputExtras(0) = book.priceSales
            binding.description.text = book.description
            binding.title.text = book.title
        }
    }
}

