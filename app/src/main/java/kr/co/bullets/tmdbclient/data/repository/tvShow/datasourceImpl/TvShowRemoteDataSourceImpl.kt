package kr.co.bullets.tmdbclient.data.repository.tvShow.datasourceImpl

import kr.co.bullets.tmdbclient.data.api.TMDBService
import kr.co.bullets.tmdbclient.data.model.tvshow.TvShowList
import kr.co.bullets.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apikey: String
) : TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apikey)
}