package com.axeldavalos.moviesapplication.data.remote

import com.axeldavalos.moviesapplication.domain.model.Movie
import com.axeldavalos.moviesapplication.domain.model.MovieDetail
import com.axeldavalos.moviesapplication.domain.model.MovieResponse
import retrofit2.Call

class MovieService(private val api: MovieApi) :  MovieApi  {
    override fun getMovies(api_key: String?): Call<MovieResponse> {

        return  api.getMovies(api_key)
    }

    override fun getMovieDetail(movie_id: Int, api_key: String?): Call<MovieDetail> {
        return api.getMovieDetail(movie_id, api_key)
    }

}