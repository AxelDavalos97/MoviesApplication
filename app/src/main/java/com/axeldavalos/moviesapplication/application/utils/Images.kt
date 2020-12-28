package com.axeldavalos.moviesapplication.application.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import com.axeldavalos.moviesapplication.R


@BindingAdapter("app:imageUrl")
fun ImageView.loadImageByURL(url: String?) =
    if(url!= null) this.load("https://image.tmdb.org/t/p/w500$url"){crossfade(true)
        crossfade(100)
        scaleType = ImageView.ScaleType.FIT_XY}
    else this.load(R.drawable.movies)   {
    crossfade(true)
    crossfade(100)
    scaleType = ImageView.ScaleType.FIT_XY
}