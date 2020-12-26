package com.axeldavalos.moviesapplication.data.repositoryImpl

import android.content.Context
import com.axeldavalos.moviesapplication.application.utils.Either
import com.axeldavalos.moviesapplication.application.utils.Failure
import com.axeldavalos.moviesapplication.application.utils.Repository
import com.axeldavalos.moviesapplication.data.remote.MovieService
import com.axeldavalos.moviesapplication.domain.model.Movie
import com.axeldavalos.moviesapplication.domain.model.MovieDetail
import com.axeldavalos.moviesapplication.domain.model.MovieResponse
import com.axeldavalos.moviesapplication.domain.repository.MovieRepository

class MovieRepositoryImpl(private val service : MovieService) :Repository(), MovieRepository{
    override fun getMovies(api_key: String, context: Context): Either<Failure, MovieResponse> {
        return request(service.getMovies(api_key), {it}, MovieResponse())
    }

    override fun getMovieDetail(
        id_movie: Int,
        api_key: String,
        context: Context
    ): Either<Failure, MovieDetail> {
        return request(service.getMovieDetail(id_movie,api_key),{it},
            MovieDetail(0,"","","","","",0, listOf()
            ))
    }
}