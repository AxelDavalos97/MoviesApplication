package com.axeldavalos.moviesapplication.data.remote

import com.axeldavalos.moviesapplication.domain.model.Movie
import com.axeldavalos.moviesapplication.domain.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("now_playing")
    fun getMovies(@Query("api_key") api_key: String?): Call<MovieResponse>
    @GET("")
    fun getMovieDetail(movie_id: Int , @Query("api_key") api_key: String? ): Call<Movie>
}