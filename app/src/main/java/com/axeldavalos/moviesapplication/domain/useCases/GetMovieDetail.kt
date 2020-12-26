package com.axeldavalos.moviesapplication.domain.useCases

import android.content.Context
import com.axeldavalos.moviesapplication.application.utils.Either
import com.axeldavalos.moviesapplication.application.utils.Failure
import com.axeldavalos.moviesapplication.application.utils.UseCase
import com.axeldavalos.moviesapplication.data.repositoryImpl.MovieRepositoryImpl
import com.axeldavalos.moviesapplication.domain.model.Movie


class GetMovieDetail(private val repo: MovieRepositoryImpl) :
    UseCase<Movie, GetMovieDetail.Params>() {
    override suspend fun run(params: Params): Either<Failure, Movie> =
        repo.getMovieDetail(params.idMovie,params.api_key,params.context)

    data class Params(val idMovie: Int ,val api_key: String, val context: Context)
}
