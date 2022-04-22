package com.example.dadok.model


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class BookViewModel(private val repositoryImpl: BookRepositoryImpl): ViewModel() {
    val allBooks: LiveData<List<SaveBook>> =
        repositoryImpl.allBooks.asLiveData()

}