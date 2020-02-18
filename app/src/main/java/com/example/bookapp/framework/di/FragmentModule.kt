package com.example.bookapp.framework.di

import androidx.navigation.fragment.NavHostFragment
import com.example.bookapp.ui.bookdetails.BookDetailsFragment
import com.example.bookapp.ui.booklist.BookListFragment
import org.koin.dsl.module

val fragmentModule = module {
    factory { BookListFragment() }
    factory { BookDetailsFragment() }
    factory { NavHostFragment() }
}