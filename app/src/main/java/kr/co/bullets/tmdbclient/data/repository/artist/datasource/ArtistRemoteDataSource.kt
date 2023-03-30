package kr.co.bullets.tmdbclient.data.repository.artist.datasource

import kr.co.bullets.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>
}