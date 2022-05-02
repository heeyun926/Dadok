package com.example.dadok.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dadok.data.Book
import com.example.dadok.databinding.ItemViewpagerBooklistBinding
import com.example.dadok.model.SaveBook

class SaveBookAdapter(private val onItemClicked: (SaveBook)->Unit):
    ListAdapter<SaveBook, SaveBookAdapter.Holder>(DiffUtil) {

    inner class Holder(private val binding: ItemViewpagerBooklistBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(data: SaveBook){
                    binding.title.text = data.title
                    binding.author.text = data.author
                    data.bookStatus

                    Glide
                        .with(binding.mainImg.context)
                        .load(data.img)
                        .into(binding.mainImg)
                    binding.mainImg.clipToOutline = true

                    Glide
                        .with(binding.status.context)
                        .load(data.subImg)
                        .into(binding.status)
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemViewpagerBooklistBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener{
            onItemClicked(current)
        }
        holder.bind(current)
    }

    companion object {
        private val DiffUtil = object: DiffUtil.ItemCallback<SaveBook>() {
            override fun areItemsTheSame(oldItem: SaveBook, newItem: SaveBook): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: SaveBook, newItem: SaveBook): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }

}