package com.example.dadok.model

import androidx.annotation.WorkerThread

class BookRepositoryImpl(private val bookDao: BookDao) {
    val allBook = bookDao.getAll()

    @WorkerThread
    fun insertBook(saveBook: SaveBook){
        bookDao.insertBook(saveBook)
    }
    fun deleteBook(saveBook: SaveBook){
        bookDao.deleteBook(saveBook)
    }
    fun updateBook(saveBook: SaveBook){
        bookDao.updateBook(saveBook)
    }
}