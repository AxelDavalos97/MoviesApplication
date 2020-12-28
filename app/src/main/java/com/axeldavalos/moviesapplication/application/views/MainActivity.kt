package com.axeldavalos.moviesapplication.application.views

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.axeldavalos.moviesapplication.R
import com.axeldavalos.moviesapplication.application.adapter.MoviesAdapter
import com.axeldavalos.moviesapplication.application.viewModels.MainViewModel
import com.axeldavalos.moviesapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private var binding: ActivityMainBinding? = null
    private var adapter =  MoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewBinding()
        setAdapter()
        setMoviesObserver()
        getMovies()
    }

    private fun setViewBinding() {
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java).also { viewModel = it }
        binding?.vm = viewModel
        binding?.lifecycleOwner = this
    }

    private fun setAdapter() {
        binding?.rcvMovies?.adapter = adapter
    }

    private fun setMoviesObserver() {
        viewModel.moviesList!!.observe(this, {
            adapter.submitList(it)
            Handler().postDelayed({
                adapter.notifyDataSetChanged()
            }, 50)
        })
    }

    private fun getMovies() {
        viewModel.getMoviesList()
    }

}