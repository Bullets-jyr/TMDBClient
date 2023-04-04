package kr.co.bullets.tmdbclient.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclient.presentation.di.artist.ArtistSubComponent
import kr.co.bullets.tmdbclient.presentation.di.movie.MovieSubComponent
import kr.co.bullets.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

// Next We will create the app module which provides the application context dependency.
// Here we need to list all the sub components with the module annotation.
@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
// Let’s add context as Constructor parameter.
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}