package com.axeldavalos.moviesapplication.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load


@BindingAdapter("app:imageUrl")
fun ImageView.loadImageByURL(url: String) = this.load(url) {
    crossfade(true)
    crossfade(100)
    scaleType = ImageView.ScaleType.FIT_XY
}