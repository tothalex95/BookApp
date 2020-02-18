package com.example.bookapp.framework.db.dao

import androidx.room.*
import androidx.room.Dao
import com.example.bookapp.framework.db.entity.BookDbEntity

@Dao
interface BookDao {

    @Insert
    suspend fun create(entity: BookDbEntity)

    @Query("SELECT * FROM books WHERE id = :id")
    suspend fun readById(id: Int): BookDbEntity?

    @Query("SELECT * FROM books")
    suspend fun readAll(): List<BookDbEntity>

    @Update
    suspend fun update(entity: BookDbEntity)

    @Delete
    suspend fun delete(entity: BookDbEntity)

}