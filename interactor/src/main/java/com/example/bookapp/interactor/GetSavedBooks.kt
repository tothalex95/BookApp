package com.example.bookapp.interactor

import com.example.bookapp.data.BookRepository
import com.example.bookapp.domain.Book

class GetSavedBooks(
    private val bookRepository: BookRepository
):AbstractInteractor<GetSavedBooks.Parameter, GetSavedBooks.Result>() {

    override suspend fun execute(parameter: Parameter): Result {
        return Result(bookRepository.findFavorites())
    }

    data class Parameter(
        val nothing: Nothing? = null
    )

    data class Result(
        val books: List<Book>
    )

}