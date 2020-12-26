package com.axeldavalos.moviesapplication.application.utils


import retrofit2.Call

abstract class Repository {

    fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Either.Right(transform((response.body() ?: default)))
                false -> Either.Left(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError)
        }
    }

  /*  fun <T, R> localRequest(
        function: () -> T,
        transform: (T) -> R,
        default: T
    ): Either<Failure, R> {
        return try {
            val response = function()
            Right(transform((response ?: default)))
        } catch (exception: Throwable) {
            Left(Failure.LocalError)
        }
    }*/
}