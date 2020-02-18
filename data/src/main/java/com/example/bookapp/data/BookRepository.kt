package com.example.bookapp.data

import com.example.bookapp.domain.Book

class BookRepository(
    private val bookDataSource: BookDataSource
): Repository<Book> {

    override suspend fun save(entity: Book) = bookDataSource.save(entity)

    suspend fun findByQuery(query: String) = bookDataSource.findByQuery(query)

    suspend fun findFavorites() = bookDataSource.findFavorites()

}