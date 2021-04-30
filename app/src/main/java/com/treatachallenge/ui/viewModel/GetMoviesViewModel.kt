package com.treatachallenge.ui.viewModel


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.treatachallenge.data.MoviesRepository
import com.treatachallenge.data.local.MovieEntity
import com.treatachallenge.ui.model.detail.DetailRequestBody
import com.treatachallenge.ui.model.detail.MovieDetailModel
import com.treatachallenge.ui.model.list.Request
import com.treatachallenge.ui.model.list.RequestBodyModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

class GetMoviesViewModel @ViewModelInject constructor(private val repository: MoviesRepository ) :ViewModel() {
    private val currentQuery = MutableLiveData(requestBodyModel)
    private var detailRequestBody: DetailRequestBody? =null
    val detailMutableLiveData=  MutableLiveData<String>()
    var getMovieLiveData:LiveData<MovieEntity>? =null
    var getFavoritesLiveData:LiveData<List<MovieEntity>>?= null
    val movies = currentQuery.switchMap { query ->
        repository.getMovieResult().cachedIn(viewModelScope)
    }

    val detailLiveData = liveData<MovieDetailModel> {
        detailRequestBody?.let {
            repository.getDetailMovie(it)
                .onStart {
                    detailMutableLiveData.value = "loading"
                }
                .catch {
                    detailMutableLiveData.value = "error"
                    it.localizedMessage
                }
                .collect {
                    detailMutableLiveData.value = "ok"
                    emit(it)
                }
        }
    }
    fun getDetail(requestBody: DetailRequestBody){

        detailRequestBody = requestBody
    }

    fun insertMovie(movieEntity: MovieEntity){
        repository.insertMovie(movieEntity)
    }

    fun removeFromFavorite(contentId: Long){
        repository.removeFromFavorite(contentId)
    }

    fun getCurrentMovie(contentId: Long){
         getMovieLiveData = repository.getMovieDao.getSpecificMovie(contentId).flowOn(Dispatchers.Main).asLiveData(context = viewModelScope.coroutineContext)
    }
    fun getAllFavorites(){
        getFavoritesLiveData = repository.getMovieDao.getAll().flowOn(Dispatchers.IO).asLiveData(context = viewModelScope.coroutineContext)
    }

    companion object {
        val requestProperties = Request(2,null, 10,1 ,"createdate" ,"desc")
        val requestBodyModel=  RequestBodyModel(requestProperties)
    }
}