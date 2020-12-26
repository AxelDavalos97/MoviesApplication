package com.axeldavalos.moviesapplication.application.viewModels

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.axeldavalos.moviesapplication.BuildConfig
import com.axeldavalos.moviesapplication.domain.model.Movie
import com.axeldavalos.moviesapplication.domain.model.MovieResponse
import com.axeldavalos.moviesapplication.domain.useCases.GetMovies
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

@ActivityScoped
class MainViewModel  @ViewModelInject constructor(
    private val getMovies: GetMovies,
    @ApplicationContext private val context: Context
) : ViewModel() {

    val moviesList = MutableLiveData(mutableListOf<MovieBoxViewModel>())

    fun getMoviesList(){

        getMovies.execute(
            { it ->
                it.either({
                Toast.makeText(context,it.msg,Toast.LENGTH_SHORT)
            }, {
                handleGetMovies(it)
            }) },
            GetMovies.Params(api_key = BuildConfig.THE_MOVIE_DB_API_TOKEN , context = context)
        )
    }

    private fun handleGetMovies(movies: MovieResponse) {

        if (movies.movies.isNullOrEmpty()) {
            return
        }
        val list = mutableListOf<MovieBoxViewModel>()
        movies.movies.forEach {
            val row = MovieBoxViewModel()
            row.setData(it)
            list.add(row)
        }
        this.moviesList.postValue(list)

    }

}