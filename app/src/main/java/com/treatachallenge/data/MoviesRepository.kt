package com.treatachallenge.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.treatachallenge.data.local.MovieDao
import com.treatachallenge.data.local.MovieEntity
import com.treatachallenge.ui.model.detail.DetailRequestBody
import com.treatachallenge.ui.model.detail.MovieDetailModel
import com.treatachallenge.utils.Constants
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepository @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDao: MovieDao
) {
    val getMovieDao: MovieDao = movieDao
    fun getMovieResult() =
        Pager(
            config = PagingConfig(
                pageSize = Constants.PAGE_SIZE,
                maxSize = 100,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { MoviePagingSource(movieApi) }
        ).liveData

    fun getDetailMovie(requestBody: DetailRequestBody): Flow<MovieDetailModel> {
        return flow {
            val response = movieApi.getDetailMovie(requestBody)
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

    fun insertMovie(movieEntity: MovieEntity) {
        CoroutineScope(SupervisorJob()).launch {
            movieDao.insertMovie(movieEntity)
        }
    }

    fun removeFromFavorite(contentId: Long) {
        CoroutineScope(SupervisorJob()).launch {
            movieDao.remove(contentId)
        }
    }

}