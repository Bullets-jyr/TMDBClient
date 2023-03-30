package kr.co.bullets.tmdbclient.data.repository.artist.datasource

import kr.co.bullets.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>

    suspend fun saveArtistsToDB(artists: List<Artist>)

    suspend fun clearAll()
}