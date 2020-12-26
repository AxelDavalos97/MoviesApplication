package com.axeldavalos.moviesapplication.application.di

import com.axeldavalos.moviesapplication.data.remote.MovieService
import com.axeldavalos.moviesapplication.data.repositoryImpl.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideMovieRepositoryImpl(movieService: MovieService):MovieRepositoryImpl {
        return MovieRepositoryImpl(movieService)
    }

}