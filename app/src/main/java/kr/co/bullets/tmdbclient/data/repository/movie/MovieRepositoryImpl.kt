package kr.co.bullets.tmdbclient.data.repository.movie

import android.util.Log
import kr.co.bullets.tmdbclient.data.model.movie.Movie
import kr.co.bullets.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import kr.co.bullets.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kr.co.bullets.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import kr.co.bullets.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        // Here we can just call to getmoviesFromCache() function.
        // If cache data available system will return them.
        // If not system will take them from the data base and retrun them.
        // If they are not available in the database system will download them from the TMDB Web API.
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        // In order to update movies, we need to get movie data from the web api first.
        val newListOfMovies = getMoviesFromAPI()
        // Then we need to clear the database table with outdated data.
        movieLocalDataSource.clearAll()
        // After that we need to save the new list of movies to the database.
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        // Let’s also save that list to the cache.
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        // Finally, we need to return this list.
        return newListOfMovies
    }

    // I am going to create functions for getting movies from api, database and cache using those datasources.
    // Since we are going to call to functions which use coroutines,we need to write these functions as suspending functions.
    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            // Now, we will write codes to get the data from the api inside this try catch block.
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()

            // If the response body is available, we can write codes to get the list of movies using the movies property of it.
            if (body != null) {
                // Response comes as a MovieList object which holds a list of movies.
                movieList = body.movies
            }
        } catch (exception: Exception) {
            // Later, we can use LiveData to handle exceptions after we completed the presentation layer.
            Log.i("MyTag", exception.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            // This time we will get the movie list from the local data source.
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        // If the size of this list is greater than zero, that means movie data are available in the database table.
        if (movieList.size > 0) {
            return movieList
        } else {
            // If there is no movie data available in the data base, we need to take them from the rest api and save them to the database.
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        } else {
            // Here , if cached data not available , we need to get data from the database and save them to the cache.
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}