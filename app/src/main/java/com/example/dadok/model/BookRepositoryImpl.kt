package com.example.dadok.model

import androidx.annotation.WorkerThread

class BookRepositoryImpl(private val bookDao: BookDao) {
    val allBook = bookDao.getAll()
    @WorkerThread
    fun insert(saveBook: SaveBook){
        bookDao.insertBook(saveBook)
    }
}