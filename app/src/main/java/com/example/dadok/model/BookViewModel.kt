package com.example.dadok.model


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class BookViewModel(private val repositoryImpl: BookRepositoryImpl): ViewModel() {
    val allBooks: LiveData<List<SaveBook>> =
        repositoryImpl.allBook.asLiveData()
}