package kr.co.bullets.tmdbclient.presentation.di

import kr.co.bullets.tmdbclient.presentation.di.artist.ArtistSubComponent
import kr.co.bullets.tmdbclient.presentation.di.movie.MovieSubComponent
import kr.co.bullets.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent

    fun createTvShowSubComponent(): TvShowSubComponent

    fun createArtistSubComponent(): ArtistSubComponent
}