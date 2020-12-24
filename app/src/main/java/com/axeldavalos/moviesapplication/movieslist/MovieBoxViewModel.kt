package com.axeldavalos.moviesapplication.movieslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.axeldavalos.moviesapplication.model.Movie
import com.axeldavalos.moviesapplication.utils.RecyclerViewViewModel

class MovieBoxViewModel : RecyclerViewViewModel() {
    val img = MutableLiveData("")
    val title = MutableLiveData("")
    val date = MutableLiveData("")
    val votes = MutableLiveData("")


    fun setData(movie: Movie) {
        img.postValue(movie.image)
        title.postValue(movie.title)
        date.postValue(movie.date)
        votes.postValue(movie.votes)
    }
}