package kr.co.bullets.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclient.domain.repository.ArtistRepository
import kr.co.bullets.tmdbclient.domain.repository.MovieRepository
import kr.co.bullets.tmdbclient.domain.repository.TvShowRepository
import kr.co.bullets.tmdbclient.domain.usecase.*

@Module
class UseCaseModule {

    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }
}