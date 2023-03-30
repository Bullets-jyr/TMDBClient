package kr.co.bullets.tmdbclient.domain.usecase

import kr.co.bullets.tmdbclient.data.model.artist.Artist
import kr.co.bullets.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtist()
}