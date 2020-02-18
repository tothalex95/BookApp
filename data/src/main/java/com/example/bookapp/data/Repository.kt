package com.example.bookapp.data

interface Repository<Entity> {

    suspend fun save(entity: Entity)

}