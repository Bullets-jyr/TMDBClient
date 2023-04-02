package kr.co.bullets.tmdbclient.domain.repository

import kr.co.bullets.tmdbclient.data.model.movie.Movie

// The implementation class of this interface will implement this function.
// Our use case class don’t need to know about the implementation.
interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}