package kr.co.bullets.tmdbclient.data.repository.movie.datasourceImpl

import kr.co.bullets.tmdbclient.data.model.movie.Movie
import kr.co.bullets.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

// Here we are going to use a very basic caching mechanism.
// In this class we will create an ArrayList of Movie instances,
// Then, whenever the user launches the app and load movie data for the first time we will assign that list to this arraylist.
// We will keep this MovieCacheDataSourceImpl instance which holds the arraylist as a singleton using dagger.
// So, if the user wants to load the movie list again, instead of using the data base we can just use the cached list.
class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        // We need to convert this list to an arrayList
        movieList = ArrayList(movies)
    }
}