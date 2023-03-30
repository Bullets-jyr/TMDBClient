package kr.co.bullets.tmdbclient.data.repository.tvshow.datasource

import kr.co.bullets.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TvShow>

    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)

    suspend fun clearAll()
}