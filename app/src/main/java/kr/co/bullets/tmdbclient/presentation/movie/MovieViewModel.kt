package kr.co.bullets.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kr.co.bullets.tmdbclient.domain.usecase.GetMoviesUseCase
import kr.co.bullets.tmdbclient.domain.usecase.UpdateMoviesUseCase

// From the view model we will only invoke those use case functions.
class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    // This function will invoke execute function of the getMoviesUseCase and emit received list as live data.
    // Since we are using coroutines we will use a live data block here.
    // We are not explicitly provide any dispatcher here. So coroutine will use the Main thread.
    // Since we have used IO thread in the data sources, calling them from the UI thread is the best practice.
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        // the movieList as live data.
        emit(movieList)
    }

    fun updateMovies() = liveData {
        // Here we will clear all the data in the movie table of the database, Download new data from the tmdb api and save them to database.
        // We have already implemented those functions in the data layer.
        // All we need to do is call to the execute function of the updateMoviesUseCase.
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}