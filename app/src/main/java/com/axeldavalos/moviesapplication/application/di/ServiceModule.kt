package com.axeldavalos.moviesapplication.application.di

import com.axeldavalos.moviesapplication.data.remote.MovieApi
import com.axeldavalos.moviesapplication.data.remote.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object ServiceModule {

    @Provides
    @ActivityRetainedScoped
    fun provideFaceDetectionService(movieApi: MovieApi) : MovieService {
        return MovieService(movieApi)
    }

}