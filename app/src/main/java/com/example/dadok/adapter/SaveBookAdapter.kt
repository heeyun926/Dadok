package com.example.dadok.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dadok.data.Book
import com.example.dadok.databinding.ItemViewpagerBooklistBinding
import com.example.dadok.model.SaveBook

class SaveBookAdapter(): ListAdapter<SaveBook, SaveBookAdapter.Holder>(diffUtil){

    inner class Holder(private val binding: ItemViewpagerBooklistBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(data: SaveBook){

                }
            }
}