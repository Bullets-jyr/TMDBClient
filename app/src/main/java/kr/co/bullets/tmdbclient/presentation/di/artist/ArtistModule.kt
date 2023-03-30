package kr.co.bullets.tmdbclient.presentation.di.artist

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclient.domain.usecase.GetArtistsUseCase
import kr.co.bullets.tmdbclient.domain.usecase.UpdateArtistsUseCase
import kr.co.bullets.tmdbclient.presentation.artist.ArtistViewModelFactory

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}