package kr.co.bullets.tmdbclient.domain.usecase

import kr.co.bullets.tmdbclient.data.model.movie.Movie
import kr.co.bullets.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    // Now, a view model class can call to this usecase function to get a list of movies.
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}