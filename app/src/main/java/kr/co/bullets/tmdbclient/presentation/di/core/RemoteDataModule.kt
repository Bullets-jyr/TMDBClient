package kr.co.bullets.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclient.data.api.TMDBService
import kr.co.bullets.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import kr.co.bullets.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import kr.co.bullets.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import kr.co.bullets.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import kr.co.bullets.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import kr.co.bullets.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}