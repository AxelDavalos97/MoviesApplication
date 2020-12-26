package com.axeldavalos.moviesapplication.application.viewModels

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.axeldavalos.moviesapplication.BuildConfig
import com.axeldavalos.moviesapplication.R
import com.axeldavalos.moviesapplication.domain.model.Movie
import com.axeldavalos.moviesapplication.domain.model.MovieDetail
import com.axeldavalos.moviesapplication.domain.useCases.GetMovieDetail
import com.axeldavalos.moviesapplication.domain.useCases.GetMovies
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
class MovieDetailViewModel @ViewModelInject constructor(
                            private val getMovieDetail: GetMovieDetail,
                            @ApplicationContext private val context: Context
): ViewModel() {
    private var id = 0

    val img = MutableLiveData("")
    val title = MutableLiveData("")
    val date = MutableLiveData("")
    val duration = MutableLiveData("")
    val votes = MutableLiveData("")
    val genres = MutableLiveData("")
    val description = MutableLiveData("")
    val rating = MutableLiveData("")

    fun getMovieDetail(){
        getMovieDetail.execute(
            { it ->
                it.either({
                    Toast.makeText(context, R.string.general_error, Toast.LENGTH_SHORT)
                }, {
                    setData(it)
                }) },
            GetMovieDetail.Params(idMovie = id,api_key = BuildConfig.THE_MOVIE_DB_API_TOKEN , context = context)
        )
    }

    fun setIdMovie(idMovie: Int){
        id = idMovie
    }

    private fun setData(movie: MovieDetail) {
        img.postValue(movie.image)
        title.postValue(movie.title)
        date.postValue(movie.date)
        votes.postValue(movie.votes)
        description.postValue(movie.description)
        rating.postValue(movie.votes)
        val movieDuration = movie.duration
        var genresConcatenated = ""
        movie.genres.forEach{
            val name = it.name
            genresConcatenated += "$name "
        }
        this.duration.postValue("$movieDuration min")
        this.genres.postValue(genresConcatenated)
    }
}