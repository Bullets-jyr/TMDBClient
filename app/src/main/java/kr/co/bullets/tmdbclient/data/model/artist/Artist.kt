package kr.co.bullets.tmdbclient.data.model.artist


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

// If we keep this in this way, room data base table name will be same as the data class name. Table name will be artist.
// But if we want a different name, we can give it as the value of the table name property.
// Actually providing a different name for the data base table is the best practice. We have to also mark a primary key. For this entity primary key should be the id.
// If we want to have different names for data base table columns we can give them using columninfo
@Entity(tableName = "popular_artists")
data class Artist(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    // But I am not going to do it now.
    // Let’s just keep the data class variable names as column names.
//    @ColumnInfo(name = "artist_name")
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)