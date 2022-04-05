package com.example.dadok.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dadok.data.Book
import com.example.dadok.data.SearchBook
import com.example.dadok.databinding.ItemReycyclerSearchResultBinding

class BookAdapter(private val itemCLickedListener: (Book)->Unit)
    : ListAdapter<Book, BookAdapter.Holder>(diffUtil){

    //View Binding(item_recycler_search_result
    inner class Holder(val binding: ItemReycyclerSearchResultBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(data: Book){
            binding.title.text = data.title
            binding.author.text = data.author
            binding.publisher.text = data.publisher

            binding.root.setOnClickListener{
                itemCLickedListener(data)
            }
            Glide
                .with(binding.bookImg.context)
                .load(data.coverSmallUrl)
                .into(binding.bookImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.Holder {
        val binding = ItemReycyclerSearchResultBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: BookAdapter.Holder, position: Int) {
        holder.bind(currentList[position])

    }
    //DiffUtil 알아보기
    companion object{
        //같은 값 제어
        val diffUtil = object: DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}