package kr.co.bullets.tmdbclient.presentation.di.tvshow

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclient.domain.usecase.GetTvShowsUseCase
import kr.co.bullets.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import kr.co.bullets.tmdbclient.presentation.tvshow.TvShowViewModelFactory

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideMovieViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}