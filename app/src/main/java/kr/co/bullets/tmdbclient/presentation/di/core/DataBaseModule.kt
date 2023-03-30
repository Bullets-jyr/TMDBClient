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

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

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