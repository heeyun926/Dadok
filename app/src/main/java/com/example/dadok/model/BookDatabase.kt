package com.example.dadok.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SaveBook::class], version = 1)
abstract class BookDatabase: RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        private var instance: BookDatabase? = null

        fun getInstance(context: Context): BookDatabase? {
            if (instance == null) {
                synchronized(BookDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        BookDatabase::class.java, "bookDatabase")
                        .fallbackToDestructiveMigration()
                        .build()

                }
            }
            return instance
        }
        fun destroyInstance() {
            instance = null
        }
    }
}