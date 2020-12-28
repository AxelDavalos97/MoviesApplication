package com.axeldavalos.moviesapplication.application.viewModels

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.axeldavalos.moviesapplication.BuildConfig
import com.axeldavalos.moviesapplication.R
import com.axeldavalos.moviesapplication.application.datasource.MoviesDataSourceFactory
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

    val progressBarVisibility = MutableLiveData(View.GONE)
    val isLoading = MutableLiveData(false)
    var moviesList: LiveData<PagedList<MovieBoxViewModel>>? = null
    private val pageSize = 10
    private val movieDataSourceFactory: MoviesDataSourceFactory = MoviesDataSourceFactory(getMovies, this,context)

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize)
            .setEnablePlaceholders(false)
            .build()
        moviesList = LivePagedListBuilder(
            movieDataSourceFactory,
            config
        ).build()
    }
    fun getMoviesList(){
        progressBarVisibility.postValue(View.VISIBLE)
        isLoading.postValue(true)
    }


    fun setStateNonLoading(){
        progressBarVisibility.postValue(View.GONE)
        isLoading.postValue(false)
    }

    fun setStateLoading(){
        progressBarVisibility.postValue(View.VISIBLE)
        isLoading.postValue(true)
    }

    fun handleError(){
        Toast.makeText(context, R.string.general_error,Toast.LENGTH_SHORT)
        progressBarVisibility.postValue(View.GONE)
        isLoading.postValue(false)
    }

    fun onRefresh(){
        movieDataSourceFactory.refresh()
    }



}