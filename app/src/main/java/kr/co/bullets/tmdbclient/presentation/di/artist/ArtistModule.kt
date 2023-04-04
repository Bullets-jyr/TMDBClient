package kr.co.bullets.tmdbclient.presentation.di.artist

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclient.domain.usecase.GetArtistsUseCase
import kr.co.bullets.tmdbclient.domain.usecase.UpdateArtistsUseCase
import kr.co.bullets.tmdbclient.presentation.artist.ArtistViewModelFactory

// Here, let’s create a provider function to provide ArtistViewModelFactory dependency.
@Module
class ArtistModule {

    // Now we can use this newly creted ArtistScope as the scope of ArtistViewModelFactory dependency.
    // So, let’s annotate this provider function with ArtistScope annotation.
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}