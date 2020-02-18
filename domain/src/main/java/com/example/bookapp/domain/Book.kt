package com.example.bookapp.domain

data class Book(
    val title: String,
    val authors: List<String>?,
    val publisher: String?,
    val description: String?,
    val thumbnail: String?
)