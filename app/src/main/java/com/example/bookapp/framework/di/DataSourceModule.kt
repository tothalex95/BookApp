package com.example.bookapp.framework.di

import com.example.bookapp.data.BookDataSource
import com.example.bookapp.framework.datasource.BookDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<BookDataSource> { BookDataSourceImpl(get(), get(), get(), get()) }
}