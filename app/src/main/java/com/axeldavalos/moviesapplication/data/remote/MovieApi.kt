package com.axeldavalos.moviesapplication.data.remote

import com.axeldavalos.moviesapplication.domain.model.Movie
import com.axeldavalos.moviesapplication.domain.model.MovieDetail
import com.axeldavalos.moviesapplication.domain.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/now_playing")
    fun getMovies(@Query("api_key") api_key: String?, @Query("page") page:Int): Call<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id")movie_id: Int , @Query("api_key") api_key: String? ): Call<MovieDetail>
}