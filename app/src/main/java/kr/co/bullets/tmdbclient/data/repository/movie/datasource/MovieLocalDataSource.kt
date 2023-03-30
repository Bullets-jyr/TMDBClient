package kr.co.bullets.tmdbclient.data.repository.movie.datasource

import kr.co.bullets.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>

    suspend fun saveMoviesToDB(movies: List<Movie>)

    suspend fun clearAll()
}