package com.example.bookapp.framework.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val title: String,
    val authors: String?,
    val publisher: String?,
    val description: String?,
    val thumbnail: String?
)