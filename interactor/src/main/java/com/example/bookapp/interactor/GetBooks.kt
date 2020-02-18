package com.example.bookapp.interactor

import com.example.bookapp.data.BookRepository
import com.example.bookapp.domain.Book

class GetBooks(
    private val bookRepository: BookRepository
) : AbstractInteractor<GetBooks.Parameter, GetBooks.Result>() {

    override suspend fun execute(parameter: Parameter): Result {
        return Result(bookRepository.findByQuery(parameter.query))
    }

    data class Parameter(
        val query: String
    )

    data class Result(
        val books: List<Book>
    )

}