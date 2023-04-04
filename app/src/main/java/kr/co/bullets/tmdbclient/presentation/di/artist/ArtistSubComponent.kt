package kr.co.bullets.tmdbclient.presentation.di.artist

import dagger.Subcomponent
import kr.co.bullets.tmdbclient.presentation.artist.ArtistActivity

// Annotate this with sub component annotation.
// Here, we need to define the list of modules related to this sub component.
// This sub component has only one module.
// Then annotate this with artist scope annotation.
// We will use this subcomponent to inject dependencies to artist activity.
// Therefore we need to define an inject function here keeping an instance of artist activity as a parameter.
@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    // We must define a subcomponent factory inside this ArtistComponent so that AppComponent knows how to create instances of this ArtistComponent sub component.
    // This is how we do it.
    // We are defining an interface inside an interface.
    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}