package kr.co.bullets.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclient.data.db.ArtistDao
import kr.co.bullets.tmdbclient.data.db.MovieDao
import kr.co.bullets.tmdbclient.data.db.TvShowDao
import kr.co.bullets.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kr.co.bullets.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import kr.co.bullets.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kr.co.bullets.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import kr.co.bullets.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kr.co.bullets.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}