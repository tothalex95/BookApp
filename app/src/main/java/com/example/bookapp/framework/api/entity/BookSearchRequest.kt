package com.example.bookapp.framework.api.entity

data class BookSearchRequest(
    val query: String,
    val maxResults: Int = 20,
    val startIndex: Int = 0
)