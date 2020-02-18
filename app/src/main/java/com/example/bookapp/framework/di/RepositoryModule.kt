package com.example.bookapp.framework.di

import com.example.bookapp.data.BookRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { BookRepository(get()) }
}