package kr.co.bullets.tmdbclient.presentation.movie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.co.bullets.tmdbclient.R
import kr.co.bullets.tmdbclient.databinding.ActivityMovieBinding
import kr.co.bullets.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    // Now we can Inject dependencies to this activity. Let’s inject MovieViewModelFactory.
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        // // let’s just go to MovieActivity and write some codes to verify our dependency injection system
        (application as Injector).createMovieSubComponent()
            .inject(this)
        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

        // Then get the live data using the view model.
        val responseLiveData = movieViewModel.getMovies()
        // And observe the live data.
        responseLiveData.observe(this, Observer {
            Log.i("MYTAG", it.toString())
        })
    }
}