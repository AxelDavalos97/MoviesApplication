package com.axeldavalos.moviesapplication.domain.useCases

import android.content.Context
import com.axeldavalos.moviesapplication.application.utils.Either
import com.axeldavalos.moviesapplication.application.utils.Failure
import com.axeldavalos.moviesapplication.application.utils.UseCase
import com.axeldavalos.moviesapplication.data.repositoryImpl.MovieRepositoryImpl
import com.axeldavalos.moviesapplication.domain.model.Movie
import com.axeldavalos.moviesapplication.domain.model.MovieResponse


class GetMovies(private val repo: MovieRepositoryImpl) :
    UseCase<MovieResponse, GetMovies.Params>() {
    override suspend fun run(params: Params): Either<Failure, MovieResponse> =
        repo.getMovies(params.api_key!!,params.context)

    data class Params(val api_key: String?=null, val context: Context)
}
