package kr.co.bullets.tmdbclient.data.repository.movie.datasource

import kr.co.bullets.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}