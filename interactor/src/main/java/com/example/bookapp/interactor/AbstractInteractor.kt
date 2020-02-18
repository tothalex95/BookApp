package com.example.bookapp.interactor

abstract class AbstractInteractor<in Parameter, out Result> {

    suspend operator fun invoke(parameter: Parameter) = execute(parameter)

    internal abstract suspend fun execute(parameter: Parameter): Result

}