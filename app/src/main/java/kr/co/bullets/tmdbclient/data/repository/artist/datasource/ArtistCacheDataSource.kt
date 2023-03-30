package kr.co.bullets.tmdbclient.data.repository.artist.datasource

import kr.co.bullets.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<Artist>

    suspend fun saveArtistsToCache(artists: List<Artist>)
}