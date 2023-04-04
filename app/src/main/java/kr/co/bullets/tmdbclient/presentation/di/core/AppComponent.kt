package kr.co.bullets.tmdbclient.presentation.di.core

import dagger.Component
import kr.co.bullets.tmdbclient.presentation.di.artist.ArtistSubComponent
import kr.co.bullets.tmdbclient.presentation.di.movie.MovieSubComponent
import kr.co.bullets.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

// Now, I am going to create the component interface.
// We need to annotate this with component annotation.
// Here we need to provide the list
// Also annotate with singleton annotation.
// For now, let’s create this appComponent interface and keep its body empty.
// We will add factory methods here once we have created subcomponents.
// @Singleton is the only scope annotation that comes with the javax.inject package.
// We can use it to annotate ApplicationComponent and the objects we want to reuse across the whole application.
// That’s why we annotated provider methods which provides dependencies we want to reuse across the whole application with Singleton annotation.

// In our application we have three view models. MovieViewModel, TvShowViewModel and ArtistViewModel.
// As an example let’s say, If we use Singleton annotation for MovieViewModel instance, Or in other words movie view model dependency.
// The instance of MovieViewModel would persist in memory even after the flow has finished.
// If we don’t want that. If we want to limit the scope of the MovieViewModel to the lifecycle of the MovieActivity
// we need to create a new sub component and a new scope for the movie data flow.
// So, In this project we will create different subcomponents and scope for each of Movie,TvShow and Artist data flows.
// Let’s create three packages for movie, tv show and artist.
@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class,
])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory

    fun tvShowSubComponent(): TvShowSubComponent.Factory

    fun artistSubComponent(): ArtistSubComponent.Factory
}