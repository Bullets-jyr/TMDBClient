package kr.co.bullets.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.co.bullets.tmdbclient.data.model.artist.Artist
import kr.co.bullets.tmdbclient.data.model.movie.Movie
import kr.co.bullets.tmdbclient.data.model.tvshow.TvShow

// Now, let’s create an abstract class for the room database as required.
// Then here, we need to define abstract functions to get dao interfaces.
@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}