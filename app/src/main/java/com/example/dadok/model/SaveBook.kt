package com.example.dadok.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saveBook")
data class SaveBook(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "TITLE") val title: String = "",
    @ColumnInfo(name = "AUTHOR") val author: String = "",
    @ColumnInfo(name = "IMAGE") val img: Int = 0,
    @ColumnInfo(name = "IMAGE") val subImg: Int = 0,
    @ColumnInfo(name = "BOOK_STATUS") val bookStatus: BookStatus = BookStatus.NULL
) {
    enum class BookStatus {
        NULL,
        BEFORE,
        ING,
        DONE
    }
}
