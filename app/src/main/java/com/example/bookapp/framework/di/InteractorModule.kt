package com.example.bookapp.framework.di

import com.example.bookapp.interactor.BookInteractors
import com.example.bookapp.interactor.GetBooks
import com.example.bookapp.interactor.GetSavedBooks
import com.example.bookapp.interactor.SaveBook
import org.koin.dsl.module

val interactorModule = module {
    single { GetBooks(get()) }
    single { SaveBook(get()) }
    single { GetSavedBooks(get()) }
    single { BookInteractors(get(), get(), get()) }
}