package com.example.bookapp.interactor

data class BookInteractors(
    val getBooks: GetBooks,
    val saveBook: SaveBook,
    val getSavedBooks: GetSavedBooks
)