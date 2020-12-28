package com.axeldavalos.moviesapplication.application.datasource

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.axeldavalos.moviesapplication.BuildConfig
import com.axeldavalos.moviesapplication.R
import com.axeldavalos.moviesapplication.application.viewModels.MainViewModel
import com.axeldavalos.moviesapplication.application.viewModels.MovieBoxViewModel
import com.axeldavalos.moviesapplication.domain.model.Movie
import com.axeldavalos.moviesapplication.domain.useCases.GetMovies
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MoviesDataSource (
    private val getMovies: GetMovies,
    private val viewModel: MainViewModel,
    private val context: Context
        ): PageKeyedDataSource<Int, MovieBoxViewModel>() {


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, MovieBoxViewModel>) {
        viewModel.setStateLoading()
        getMovies.execute(
            { it ->
                it.either({
                    viewModel.setStateNonLoading()
                    viewModel.handleError()
                }, {
                    viewModel.setStateNonLoading()
                    val list = mutableListOf<MovieBoxViewModel>()
                    it.movies!!.forEach {
                        val row = MovieBoxViewModel(context)
                        row.setData(it)
                        list.add(row)
                    }
                    callback.onResult(list,
                        null,
                        2
                    )

                }) },
            GetMovies.Params(api_key = BuildConfig.THE_MOVIE_DB_API_TOKEN , page = 1)
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MovieBoxViewModel>) {
        viewModel.setStateLoading()
        getMovies.execute(
            { it ->
                it.either({
                    viewModel.setStateNonLoading()
                    viewModel.handleError()
                }, {
                    viewModel.setStateNonLoading()
                    val list = mutableListOf<MovieBoxViewModel>()
                    it.movies!!.forEach {
                        val row = MovieBoxViewModel(context)
                        row.setData(it)
                        list.add(row)
                    }
                    callback.onResult(list,
                        params.key + 1
                    )
                }) },
            GetMovies.Params(api_key = BuildConfig.THE_MOVIE_DB_API_TOKEN , page = params.key)
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MovieBoxViewModel>) {
        viewModel.setStateLoading()
        getMovies.execute(
            { it ->
                it.either({
                    viewModel.setStateNonLoading()
                    viewModel.handleError()
                }, {

                    viewModel.setStateNonLoading()
                    val list = mutableListOf<MovieBoxViewModel>()
                    it.movies!!.forEach {
                        val row = MovieBoxViewModel(context)
                        row.setData(it)
                        list.add(row)
                    }
                    var key =  if(params.key > 1) params.key else 0
                    callback.onResult(list,
                        key
                    )
                }) },
            GetMovies.Params(api_key = BuildConfig.THE_MOVIE_DB_API_TOKEN , page = params.key)
        )
    }


}