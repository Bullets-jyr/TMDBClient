package kr.co.bullets.tmdbclient.data.repository.movie.datasourceImpl

import kr.co.bullets.tmdbclient.data.api.TMDBService
import kr.co.bullets.tmdbclient.data.model.movie.MovieList
import kr.co.bullets.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apikey: String
) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apikey)
}