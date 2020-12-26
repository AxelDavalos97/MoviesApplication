package com.axeldavalos.moviesapplication.application.viewModels

import androidx.lifecycle.MutableLiveData
import com.axeldavalos.moviesapplication.domain.model.Movie
import com.axeldavalos.moviesapplication.application.utils.RecyclerViewViewModel

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