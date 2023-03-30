package kr.co.bullets.tmdbclient.data.repository.artist.datasourceImpl

import kr.co.bullets.tmdbclient.data.api.TMDBService
import kr.co.bullets.tmdbclient.data.model.artist.ArtistList
import kr.co.bullets.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apikey: String
) : ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apikey)
}