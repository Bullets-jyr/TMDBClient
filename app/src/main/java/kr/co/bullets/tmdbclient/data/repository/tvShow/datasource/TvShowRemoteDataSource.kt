package kr.co.bullets.tmdbclient.data.repository.tvShow.datasource

import kr.co.bullets.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TvShowList>
}