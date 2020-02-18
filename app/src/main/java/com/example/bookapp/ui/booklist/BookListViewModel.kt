package com.example.bookapp.ui.booklist

import androidx.lifecycle.*
import com.example.bookapp.domain.Book
import com.example.bookapp.interactor.BookInteractors
import com.example.bookapp.interactor.GetBooks
import com.example.bookapp.interactor.GetSavedBooks
import kotlinx.coroutines.launch

class BookListViewModel(
    private val bookInteractors: BookInteractors
) : ViewModel() {

    private val _books = MutableLiveData<Result<List<Book>>>()
    val books: LiveData<Result<List<Book>>> get() = _books

    val favorites = MutableLiveData<Result<List<Book>>>()

    fun searchBooks(query: String) {
        viewModelScope.launch {
            try {
                _books.postValue(Result.success(bookInteractors.getBooks(GetBooks.Parameter(query)).books))
            } catch (exception: Exception) {
                _books.postValue(Result.failure(exception))
            }
        }
    }

    fun saveBook(book:Book) = liveData {
        try {
            bookInteractors.saveBook(book)
            emit(Result.success(book))
        } catch (exception: Exception) {
            emit(Result.failure(exception))
        }
    }

    fun getFavorites() {
        viewModelScope.launch {
            try {
                favorites.postValue(Result.success(bookInteractors.getSavedBooks(GetSavedBooks.Parameter()).books))
            } catch (exception: Exception) {
                favorites.postValue(Result.failure(exception))
            }
        }
    }

}