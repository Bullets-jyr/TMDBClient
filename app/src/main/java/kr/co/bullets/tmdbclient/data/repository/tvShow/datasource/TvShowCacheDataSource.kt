package kr.co.bullets.tmdbclient.data.repository.tvShow.datasource

import kr.co.bullets.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TvShow>

    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}