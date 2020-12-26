package com.axeldavalos.moviesapplication.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetail (

    @Json(name = "id") val id: Int,
    @Json(name = "original_title") val title: String,
    @Json(name = "vote_average") val votes: String,
    @Json(name = "release_date") val date: String,
    @Json(name = "backdrop_path") val image: String,
    @Json(name = "overview") val description: String,
    @Json(name = "runtime") val duration: Int,
    @Json(name = "genres") val genres: List<Genre>,
)