package kr.co.bullets.tmdbclient.presentation.di.artist

import javax.inject.Scope

// Now, we will create a scope for artist data. Creating a dagger scope is very straight forward.
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ArtistScope