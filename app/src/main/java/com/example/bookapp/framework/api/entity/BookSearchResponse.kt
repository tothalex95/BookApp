package com.example.bookapp.framework.api.entity

data class BookSearchResponse(
    val totalItems: Int,
    val items: List<BookApiEntity>
) {

    data class BookApiEntity(
        val selfLink: String,
        val volumeInfo: VolumeInfo
    )

    data class VolumeInfo(
        val title: String,
        val authors: List<String>?,
        val publisher: String?,
        val description: String?,
        val imageLinks: ImageLinks?
    )

    data class ImageLinks(
        val thumbnail: String
    )

}