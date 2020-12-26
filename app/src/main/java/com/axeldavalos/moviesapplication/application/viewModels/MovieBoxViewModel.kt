package com.axeldavalos.moviesapplication.application.viewModels

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.axeldavalos.moviesapplication.application.utils.RecyclerViewViewModel
import com.axeldavalos.moviesapplication.application.views.MainActivity
import com.axeldavalos.moviesapplication.application.views.MovieDetailActivity
import com.axeldavalos.moviesapplication.domain.model.Movie
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
class MovieBoxViewModel(
    @ApplicationContext private val context: Context?
) : RecyclerViewViewModel() {
    val id = MutableLiveData(0)
    val img = MutableLiveData("")
    val title = MutableLiveData("")
    val date = MutableLiveData("")
    val votes = MutableLiveData("")


    fun setData(movie: Movie) {
        id.postValue(movie.id)
        img.postValue(movie.image)
        title.postValue(movie.title)
        date.postValue(movie.date)
        votes.postValue(movie.votes)
    }

    fun onClickItem(idMovie: Int){
        val intent = Intent(context,MovieDetailActivity::class.java)
        intent.putExtra("idMovie",idMovie)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(context!!,intent,null)

    }
}