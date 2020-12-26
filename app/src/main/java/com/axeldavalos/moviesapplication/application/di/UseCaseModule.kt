package com.axeldavalos.moviesapplication.application.di

import com.axeldavalos.moviesapplication.data.repositoryImpl.MovieRepositoryImpl
import com.axeldavalos.moviesapplication.domain.useCases.GetMovieDetail
import com.axeldavalos.moviesapplication.domain.useCases.GetMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {
    @Provides
    @ActivityRetainedScoped
    fun provideGetMovies(movieRepositoryImpl: MovieRepositoryImpl) : GetMovies {
        return GetMovies(movieRepositoryImpl)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideGetMovieDetail(movieRepositoryImpl: MovieRepositoryImpl) : GetMovieDetail {
        return GetMovieDetail(movieRepositoryImpl)
    }
}