package com.axeldavalos.moviesapplication.application.di

import com.axeldavalos.moviesapplication.application.adapter.MoviesAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AdapterModule {
    @Provides
    @Singleton
    fun provideMoviesAdapter(): MoviesAdapter {
        return MoviesAdapter()
    }
}