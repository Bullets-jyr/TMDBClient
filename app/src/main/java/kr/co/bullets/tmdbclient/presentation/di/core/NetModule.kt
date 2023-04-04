package kr.co.bullets.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.co.bullets.tmdbclient.data.api.TMDBService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Annotate this with Module annotation.
// To create a retrofit instance we need to provide the base url.
// Therefore I am adding base url as a constructor parameter.
// So, this is our network module. This module provides two dependencies Retrofit instance and TMDBService instance.
// 객체가 아닌 것은 생성자 매개변수로 받는다?!
@Module
class NetModule(private val baseUrl: String) {

    // It very efficient keeping a single retrofit instance during the entire operational time of the app.
    // So, In order to make this retrofit instance dependency singleton,
    // let’s annotate this provider function with singleton annotation.
    @Singleton
    // Now , we need to annotate this provider function with provides annotation.
    @Provides
    fun provideRetrofit(): Retrofit {
        // Here we will construct a retrofit instance using its builder function call and return it.
        return Retrofit.Builder()
            // TMDB api send us data in JSON format. To convert JSON to Kotlin we need a converter factory.
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    // Now, Let’s create another function to provide an instance of TMDB Service.
    // return type should be TMDBService.
    // This function needs an instance of retrofit as a dependency.
    fun provideTMDBService(retrofit: Retrofit): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }
}