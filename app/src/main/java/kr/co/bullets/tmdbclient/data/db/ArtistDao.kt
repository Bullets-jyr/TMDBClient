package kr.co.bullets.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kr.co.bullets.tmdbclient.data.model.artist.Artist
import kr.co.bullets.tmdbclient.data.model.tvshow.TvShow

@Dao
interface ArtistDao {

    // OnConflictStrategy.REPLACE는 충돌이 발생하면 새 데이터로 기존 데이터를 대체합니다.
    // 기존 데이터가 있으면 UPDATE 쿼리를 수행하여 새 데이터로 대체하며, 그렇지 않으면 INSERT 쿼리를 수행합니다.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(): List<Artist>
}