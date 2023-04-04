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

// In our project datasources are dependencies for repositories.
// Therefore now, I am going to create modules to provide data sources.
// We have 3 types of data sources. Remote, local and cache.
// They need the api key as constructor parameters.
// So we need to add the pai key as a constructor parameter to this module.
@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    // Dagger will provide this dependency to this module.
    // We have already created a module to provide TMDBService dependency.
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