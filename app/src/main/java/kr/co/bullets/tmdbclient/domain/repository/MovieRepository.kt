package kr.co.bullets.tmdbclient.domain.repository

import kr.co.bullets.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}