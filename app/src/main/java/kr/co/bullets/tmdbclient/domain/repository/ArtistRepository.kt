package kr.co.bullets.tmdbclient.domain.repository

import kr.co.bullets.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}