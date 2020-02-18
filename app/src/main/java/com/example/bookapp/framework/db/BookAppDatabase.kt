package com.example.bookapp.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bookapp.framework.db.dao.BookDao
import com.example.bookapp.framework.db.entity.BookDbEntity

@Database(
    entities = [
        BookDbEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class BookAppDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "books.db"

        @Volatile
        private var instance: BookAppDatabase? = null

        fun getInstance(context: Context): BookAppDatabase {
            context.deleteDatabase(DATABASE_NAME)
            return instance ?: Room.databaseBuilder(
                context,
                BookAppDatabase::class.java,
                DATABASE_NAME
            ).build().also { instance = it }
        }
    }

    abstract fun bookDao(): BookDao

}