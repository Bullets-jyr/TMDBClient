package kr.co.bullets.tmdbclient.presentation.di.movie

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclient.domain.usecase.GetMoviesUseCase
import kr.co.bullets.tmdbclient.domain.usecase.UpdateMoviesUseCase
import kr.co.bullets.tmdbclient.presentation.movie.MovieViewModelFactory

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}