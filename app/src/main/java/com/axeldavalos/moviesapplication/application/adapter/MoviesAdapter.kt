package com.axeldavalos.moviesapplication.application.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.axeldavalos.moviesapplication.R
import com.axeldavalos.moviesapplication.application.viewModels.MovieBoxViewModel
import com.axeldavalos.moviesapplication.application.utils.BaseAdapter

class MoviesAdapter : BaseAdapter<MovieBoxViewModel>(diffCallback = object :
    DiffUtil.ItemCallback<MovieBoxViewModel>() {
    override fun areItemsTheSame(oldItem: MovieBoxViewModel, newItem: MovieBoxViewModel): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: MovieBoxViewModel,
        newItem: MovieBoxViewModel
    ): Boolean {
        return oldItem == newItem
    }

    })
{
    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.movie_box
    }
}