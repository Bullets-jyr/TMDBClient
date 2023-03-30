package kr.co.bullets.tmdbclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.co.bullets.tmdbclient.R
import kr.co.bullets.tmdbclient.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }
}