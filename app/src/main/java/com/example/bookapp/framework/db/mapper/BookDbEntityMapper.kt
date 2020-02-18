package com.example.bookapp.framework.db.mapper

import com.example.bookapp.domain.Book
import com.example.bookapp.framework.Mapper
import com.example.bookapp.framework.db.entity.BookDbEntity

class BookDbEntityMapper:Mapper<BookDbEntity, Book> {

    override fun mapToModel(entity: BookDbEntity): Book {
        return Book(
            entity.title,
            entity.authors?.split(","),
            entity.publisher,
            entity.description,
            entity.thumbnail
        )
    }

    override fun mapToEntity(model: Book): BookDbEntity {
        return BookDbEntity(
            null,
            model.title,
            model.authors?.joinToString(","),
            model.publisher,
            model.description,
            model.thumbnail
        )
    }

}