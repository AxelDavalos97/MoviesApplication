package com.axeldavalos.moviesapplication.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(@Json(name = "results") val movies: List<Movie>? = null)