package com.axeldavalos.moviesapplication.application.datasource

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.axeldavalos.moviesapplication.application.viewModels.MainViewModel
import com.axeldavalos.moviesapplication.application.viewModels.MovieBoxViewModel
import com.axeldavalos.moviesapplication.domain.model.Movie
import com.axeldavalos.moviesapplication.domain.useCases.GetMovies
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MoviesDataSourceFactory(
    private val getMovies: GetMovies,
    private val viewModel: MainViewModel,
    private val context: Context)
    : DataSource.Factory<Int, MovieBoxViewModel>() {

    val moviesDataSourceLiveData = MutableLiveData<MoviesDataSource>()

    override fun create(): DataSource<Int, MovieBoxViewModel> {
        val moviesDatasource = MoviesDataSource(getMovies,viewModel,context)
        moviesDataSourceLiveData.postValue(moviesDatasource)
        return moviesDatasource
    }
    fun refresh() {
        moviesDataSourceLiveData.value?.invalidate()
    }
}