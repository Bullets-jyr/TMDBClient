package kr.co.bullets.tmdbclient.data.repository.movie.datasource

import kr.co.bullets.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)
}