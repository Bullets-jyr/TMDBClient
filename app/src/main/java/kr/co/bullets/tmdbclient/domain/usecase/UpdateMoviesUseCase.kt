package kr.co.bullets.tmdbclient.domain.usecase

import kr.co.bullets.tmdbclient.data.model.movie.Movie
import kr.co.bullets.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}