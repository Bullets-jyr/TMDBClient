package kr.co.bullets.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kr.co.bullets.tmdbclient.data.model.movie.Movie

// For the database operations we need to create a Dao interface for each database table.
@Dao
interface MovieDao {

    // We need to save a list of movie instances taken from the TMDB api to the database.
    // OnConflictStrategy.REPLACE는 충돌이 발생하면 새 데이터로 기존 데이터를 대체합니다.
    // 기존 데이터가 있으면 UPDATE 쿼리를 수행하여 새 데이터로 대체하며, 그렇지 않으면 INSERT 쿼리를 수행합니다.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movies: List<Movie>)

    // When the user clicks on update icon, we need to delete all the data from the data base table first and then save new movie instances to the database.
    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    // We also need to get a list of movie instances from the data base table to display using a RecyclerView.
    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(): List<Movie>
}