package com.example.bookapp.framework.di

import com.example.bookapp.framework.api.BookApi
import com.example.bookapp.framework.api.mapper.BookApiEntityMapper
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single<Converter.Factory> { GsonConverterFactory.create() }
    single { BookApi.getInstance(get()) }

    single { BookApiEntityMapper() }
}