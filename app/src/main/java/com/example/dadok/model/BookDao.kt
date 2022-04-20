package com.example.dadok.model

import androidx.room.*

@Dao
interface BookDao {

    //SaveBook Dao
    @Query("SELECT * FROM saveBook")
    fun getAll(): List<SaveBook>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(saveBook: SaveBook)

    @Update
    fun updateBook(saveBook: SaveBook)

    @Delete
    fun deleteBook(saveBook: SaveBook)
}