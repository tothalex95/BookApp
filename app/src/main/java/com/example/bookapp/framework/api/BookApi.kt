package com.example.bookapp.framework.api

import com.example.bookapp.framework.api.entity.BookSearchResponse
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {

    companion object {
        private const val BASE_URL = "https://www.googleapis.com"

        @Volatile
        private var instance: BookApi? = null

        fun getInstance(converterFactory: Converter.Factory): BookApi {
            return instance ?: Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converterFactory)
                .build()
                .create(BookApi::class.java)
                .also { instance = it }
        }
    }

    @GET("/books/v1/volumes")
    suspend fun search(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 10,
        @Query("startIndex") startIndex: Int = 0
    ): BookSearchResponse

}