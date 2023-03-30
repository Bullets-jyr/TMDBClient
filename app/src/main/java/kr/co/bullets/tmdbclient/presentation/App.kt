package kr.co.bullets.tmdbclient.presentation

import android.app.Application
import kr.co.bullets.tmdbclient.BuildConfig
import kr.co.bullets.tmdbclient.presentation.di.Injector
import kr.co.bullets.tmdbclient.presentation.di.artist.ArtistSubComponent
import kr.co.bullets.tmdbclient.presentation.di.core.*
import kr.co.bullets.tmdbclient.presentation.di.movie.MovieSubComponent
import kr.co.bullets.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}