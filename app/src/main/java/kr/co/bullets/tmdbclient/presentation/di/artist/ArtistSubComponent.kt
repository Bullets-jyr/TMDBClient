package kr.co.bullets.tmdbclient.presentation.di.artist

import dagger.Subcomponent
import kr.co.bullets.tmdbclient.presentation.artist.ArtistActivity

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}