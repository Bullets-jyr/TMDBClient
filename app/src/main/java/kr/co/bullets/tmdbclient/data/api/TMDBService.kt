package kr.co.bullets.tmdbclient.data.api

import kr.co.bullets.tmdbclient.data.model.artist.ArtistList
import kr.co.bullets.tmdbclient.data.model.movie.MovieList
import kr.co.bullets.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// Since we are going to use coroutines for background processing, we need to define these as suspending
// So the return type of this function should be a retrofit response object of type MovieList.
interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String): Response<ArtistList>
}