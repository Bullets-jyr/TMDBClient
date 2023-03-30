package kr.co.bullets.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import kr.co.bullets.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import kr.co.bullets.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kr.co.bullets.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import kr.co.bullets.tmdbclient.data.repository.movie.MovieRepositoryImpl
import kr.co.bullets.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import kr.co.bullets.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kr.co.bullets.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import kr.co.bullets.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import kr.co.bullets.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import kr.co.bullets.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kr.co.bullets.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import kr.co.bullets.tmdbclient.domain.repository.ArtistRepository
import kr.co.bullets.tmdbclient.domain.repository.MovieRepository
import kr.co.bullets.tmdbclient.domain.repository.TvShowRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }
}