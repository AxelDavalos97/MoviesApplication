package com.axeldavalos.moviesapplication.application.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.axeldavalos.moviesapplication.R
import com.axeldavalos.moviesapplication.application.viewModels.MainViewModel
import com.axeldavalos.moviesapplication.application.viewModels.MovieDetailViewModel
import com.axeldavalos.moviesapplication.databinding.MovieDetailActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieDetailViewModel
    private var binding: MovieDetailActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewBinding()
        val idMovie =intent.getIntExtra("idMovie",0)
        viewModel.setIdMovie(idMovie = idMovie)
        viewModel.getMovieDetail()
    }

    private fun setViewBinding() {
        binding =
            DataBindingUtil.setContentView(this, R.layout.movie_detail_activity)
        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java).also { viewModel = it }
        binding?.vm = viewModel
        binding?.lifecycleOwner = this
    }

}