package kr.co.bullets.tmdbclient.data.repository.movie.datasourceImpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.bullets.tmdbclient.data.db.MovieDao
import kr.co.bullets.tmdbclient.data.model.movie.Movie
import kr.co.bullets.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    // When we are getting data from the room database, room execute that query in a back ground thread.
    // So we don’t need to explicitly write codes for background processing.
    // But, we need to invoke other dao functions from a back ground thread.
    // We will use coroutines for that.
    // To run this in a background worker thread, I am using Dispatcher.IO.
    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovie(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}