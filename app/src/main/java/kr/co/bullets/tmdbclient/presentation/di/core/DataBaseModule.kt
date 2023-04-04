package kr.co.bullets.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclient.data.db.ArtistDao
import kr.co.bullets.tmdbclient.data.db.MovieDao
import kr.co.bullets.tmdbclient.data.db.TMDBDatabase
import kr.co.bullets.tmdbclient.data.db.TvShowDao
import javax.inject.Singleton

// Now, we will create a module for database and dao dependencies.
@Module
class DataBaseModule {

    @Singleton
    @Provides
    // We need to pass the context.
    // Inside the app module we will write a provider function to provide the application context
    fun provideMovieDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    // In this project we have three DAO interfaces. Local data source classes need them as dependencies.
    // So, now let’s create 3 provider functions to return those dao dependencies.
    // TMDBDatabase should be the constructor parameter.
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }
}