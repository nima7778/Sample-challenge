package com.treatachallenge.data

import com.treatachallenge.ui.model.detail.DetailRequestBody
import com.treatachallenge.ui.model.detail.MovieDetailModel
import com.treatachallenge.ui.model.list.RequestBodyModel
import com.treatachallenge.ui.model.list.ResponseModel
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface MovieApi {
    @Headers("Content-Type: application/json")
    @POST("/api/v1/test/GetContentList")
    suspend fun getMovies(@Body requestBodyModel: RequestBodyModel) : ResponseModel

    @Headers("Content-Type: application/json",
        "Accept-Language: fa-IR")
    @POST("/api/v1/test/GetContent")
    suspend fun getDetailMovie(@Body getContent: DetailRequestBody) : MovieDetailModel
}