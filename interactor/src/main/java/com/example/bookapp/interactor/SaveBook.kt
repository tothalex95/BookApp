package com.example.bookapp.interactor

import com.example.bookapp.data.BookRepository
import com.example.bookapp.domain.Book

class SaveBook(
    private val bookRepository: BookRepository
):AbstractInteractor<Book, Unit>() {

    override suspend fun execute(parameter: Book) = bookRepository.save(parameter)

}