package com.treatachallenge.data

import retrofit2.HttpException
import java.io.IOException
import androidx.paging.PagingSource
import com.treatachallenge.ui.model.detail.DetailRequestBody
import com.treatachallenge.ui.model.list.GetContent
import com.treatachallenge.ui.model.list.Property
import com.treatachallenge.ui.model.list.Request
import com.treatachallenge.ui.model.list.RequestBodyModel
import com.treatachallenge.utils.Constants

private const val STARTING_PAGE_INDEX = 1

class MoviePagingSource (private val movieApi: MovieApi) : PagingSource<Int, GetContent>(){

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, GetContent> {
        val position = params.key ?: STARTING_PAGE_INDEX
        val requestProperties = Request(Constants.REQUEST_TYPE,null, Constants.PAGE_SIZE, position ,Constants.ORDER_BY ,Constants.ORDER)
        val requestBodyModel=  RequestBodyModel(requestProperties)
        return try {
            val response = movieApi.getMovies(requestBodyModel)
            val contents = response.result.getContentList
            LoadResult.Page(
                data = contents,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (contents.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            PagingSource.LoadResult.Error(exception)
        } catch (exception: HttpException) {
            PagingSource.LoadResult.Error(exception)
        }

    }
}