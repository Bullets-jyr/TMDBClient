package kr.co.bullets.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.co.bullets.tmdbclient.domain.usecase.GetMoviesUseCase
import kr.co.bullets.tmdbclient.domain.usecase.UpdateMoviesUseCase

// This view model class has constructor parameters.
// Therefore, we need to create a view model factory for this view model.
// This class should also have instances of GetMoviesUseCase and UpdateMoviesUseCase classes as constructor parameters.
// This class should extend ViewModelProvider.Factory class.
class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {

    // Let’s override the create function.
    // Here we need to construct a MovieViewModel passing use case instances as artugments and return as T.
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}