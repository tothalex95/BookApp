package com.example.bookapp.framework.di

import com.example.bookapp.ui.bookdetails.BookDetailsViewModel
import com.example.bookapp.ui.booklist.BookListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { BookListViewModel(get()) }
    viewModel { BookDetailsViewModel() }
}