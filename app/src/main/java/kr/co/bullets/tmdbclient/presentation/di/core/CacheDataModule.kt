package kr.co.bullets.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import kr.co.bullets.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import kr.co.bullets.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import kr.co.bullets.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import kr.co.bullets.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import kr.co.bullets.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}