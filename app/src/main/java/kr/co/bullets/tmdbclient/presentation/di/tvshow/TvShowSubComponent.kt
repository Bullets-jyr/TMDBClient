package kr.co.bullets.tmdbclient.presentation.di.tvshow

import dagger.Subcomponent
import kr.co.bullets.tmdbclient.presentation.artist.ArtistActivity
import kr.co.bullets.tmdbclient.presentation.movie.MovieActivity
import kr.co.bullets.tmdbclient.presentation.tvshow.TvShowActivity

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}