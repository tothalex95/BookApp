package com.example.bookapp.data

import com.example.bookapp.domain.Book

interface BookDataSource {

    suspend fun save(book: Book)

    suspend fun findByQuery(query: String): List<Book>

    suspend fun findFavorites(): List<Book>

}