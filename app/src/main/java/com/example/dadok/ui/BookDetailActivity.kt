package com.example.dadok.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.dadok.R
import com.example.dadok.data.Book
import com.example.dadok.databinding.ActivityBookDetailBinding
import java.io.Serializable

class BookDetailActivity : AppCompatActivity(), Serializable {

    private lateinit var binding: ActivityBookDetailBinding
    private var book: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBookDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        book = intent.getParcelableExtra("bookModel")


        Glide.with(binding.mainImg.context)
            .load(book?.coverLargeUrl).into(binding.mainImg)

        binding.title.text = book?.title
        binding.author.text = book?.author
        binding.publisher.text = book?.publisher
        binding.category.text = book?.categoryName
        binding.sales.text = book?.priceSales.toString()
        binding.description.text = book?.description
        binding.title.text = book?.title


        //img rounding
        binding.mainImg.clipToOutline = true
        //link text
        binding.linkText.setOnClickListener {
            val openUrl = Intent(android.content.Intent.ACTION_VIEW)
            Log.d("link","${book?.link}")
            openUrl.data = Uri.parse("${book?.link}")

            startActivity(openUrl)
        }
    }
}

