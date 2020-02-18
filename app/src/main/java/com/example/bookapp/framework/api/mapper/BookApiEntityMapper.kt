package com.example.bookapp.framework.api.mapper

import com.example.bookapp.domain.Book
import com.example.bookapp.framework.Mapper
import com.example.bookapp.framework.api.entity.BookSearchResponse

class BookApiEntityMapper : Mapper<BookSearchResponse.BookApiEntity, Book> {

    override fun mapToModel(entity: BookSearchResponse.BookApiEntity): Book {
        return Book(
            entity.volumeInfo.title,
            entity.volumeInfo.authors,
            entity.volumeInfo.publisher,
            entity.volumeInfo.description,
            entity.volumeInfo.imageLinks?.thumbnail
        )
    }

    override fun mapToEntity(model: Book): BookSearchResponse.BookApiEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}