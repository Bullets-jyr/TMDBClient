package kr.co.bullets.tmdbclient.presentation

import android.app.Application
import kr.co.bullets.tmdbclient.BuildConfig
import kr.co.bullets.tmdbclient.presentation.di.Injector
import kr.co.bullets.tmdbclient.presentation.di.artist.ArtistSubComponent
import kr.co.bullets.tmdbclient.presentation.di.core.*
import kr.co.bullets.tmdbclient.presentation.di.movie.MovieSubComponent
import kr.co.bullets.tmdbclient.presentation.di.tvshow.TvShowSubComponent

// we are going to create a class which extends the application class.
// Since we have subcomponents, We need to create function in side that application class to get subcomponent instances.
// This class should extend the Application class and implement the Injector interface.
// Generate the three functions of Injector interface.
// Then, declare a private reference variable for the AppComponent interface.
class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            // We don’t need to add all the core modules to the builder,
            // we only need to add modules with constructor parameters.
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    // Then, let’s implement get subcomponent functions using the app component.

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