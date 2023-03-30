package kr.co.bullets.tmdbclient.data.repository.tvShow.datasourceImpl

import kr.co.bullets.tmdbclient.data.model.tvshow.TvShow
import kr.co.bullets.tmdbclient.data.repository.tvShow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}