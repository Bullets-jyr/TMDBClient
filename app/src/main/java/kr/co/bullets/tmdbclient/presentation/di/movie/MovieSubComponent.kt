package kr.co.bullets.tmdbclient.presentation.di.movie

import dagger.Subcomponent
import kr.co.bullets.tmdbclient.presentation.artist.ArtistActivity
import kr.co.bullets.tmdbclient.presentation.movie.MovieActivity

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}