package com.example.bookapp.framework

interface Mapper<Entity, Model> {

    fun mapToModel(entity: Entity): Model

    fun mapToEntity(model: Model): Entity

}