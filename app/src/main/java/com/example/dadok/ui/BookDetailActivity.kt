package com.example.dadok.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
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

        //img rounding
        binding.mainImg.clipToOutline = true

        initItem()
        clickLink()
    }

    private fun initItem() {
        book = intent.getParcelableExtra("bookModel")

        Glide.with(binding.mainImg.context)
            .load(book?.coverLargeUrl).into(binding.mainImg)

        with(binding){
            title.text = book?.title
            author.text = book?.author
            publisher.text = book?.publisher
            category.text = book?.categoryName
            sales.text = book?.priceSales.toString()
            description.text = book?.description
        }
    }

    private fun clickLink() {
        //link text
        binding.linkText.setOnClickListener {
            val openUrl = Intent(android.content.Intent.ACTION_VIEW)
            Log.d("link","${book?.link}")
            openUrl.data = Uri.parse("${book?.link}")

            startActivity(openUrl)
        }
    }

    fun clickSave() {
        binding.saveBtn.setOnClickListener {

        }
    }

}

