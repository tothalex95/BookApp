package com.example.bookapp.framework.di

import com.example.bookapp.framework.db.BookAppDatabase
import com.example.bookapp.framework.db.mapper.BookDbEntityMapper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {
    single { BookAppDatabase.getInstance(androidApplication()) }
    single { get<BookAppDatabase>().bookDao() }

    single { BookDbEntityMapper() }
}