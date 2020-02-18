package com.example.bookapp.framework.datasource

import com.example.bookapp.data.BookDataSource
import com.example.bookapp.domain.Book
import com.example.bookapp.framework.api.BookApi
import com.example.bookapp.framework.api.mapper.BookApiEntityMapper
import com.example.bookapp.framework.db.dao.BookDao
import com.example.bookapp.framework.db.mapper.BookDbEntityMapper

class BookDataSourceImpl(
    private val bookApi: BookApi,
    private val bookApiEntityMapper: BookApiEntityMapper,
    private val bookDao: BookDao,
    private val bookDbEntityMapper: BookDbEntityMapper
) : BookDataSource {

    override suspend fun save(book: Book) {
        bookDao.create(bookDbEntityMapper.mapToEntity(book))
    }

    override suspend fun findByQuery(query: String): List<Book> {
        return bookApi.search(query).items.map { bookApiEntityMapper.mapToModel(it) }
    }

    override suspend fun findFavorites(): List<Book> {
        return bookDao.readAll().map { bookDbEntityMapper.mapToModel(it) }
    }

}