package com.axeldavalos.moviesapplication.domain.repository

import android.content.Context
import com.axeldavalos.moviesapplication.application.utils.Either
import com.axeldavalos.moviesapplication.application.utils.Failure
import com.axeldavalos.moviesapplication.domain.model.Movie
import com.axeldavalos.moviesapplication.domain.model.MovieResponse

interface MovieRepository {
    fun getMovies(api_key: String, context: Context): Either<Failure, MovieResponse>
    fun getMovieDetail(id_movie: Int,api_key: String, context: Context): Either<Failure,Movie>
}