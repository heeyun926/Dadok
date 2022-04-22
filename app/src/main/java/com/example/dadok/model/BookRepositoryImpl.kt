package com.example.dadok.model

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class BookRepositoryImpl(private val bookDao: BookDao) {
    val allBooks: Flow<List<SaveBook>> = bookDao.getAll()

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