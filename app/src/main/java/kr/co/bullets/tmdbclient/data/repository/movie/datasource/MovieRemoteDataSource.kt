package kr.co.bullets.tmdbclient.data.repository.movie.datasource

import kr.co.bullets.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    // This getPopularMovies function of the service interface returns a response instance of type MovieList
    // So, this new function should return the same.
    suspend fun getMovies(): Response<MovieList>
}