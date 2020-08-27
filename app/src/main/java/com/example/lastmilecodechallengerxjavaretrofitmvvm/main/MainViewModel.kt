package com.example.lastmilecodechallengerxjavaretrofitmvvm.main

import android.util.Log
import android.view.View
import androidx.lifecycle.*
import com.example.lastmilecodechallengerxjavaretrofitmvvm.models.Movie
import com.example.lastmilecodechallengerxjavaretrofitmvvm.models.MovieResponse
import javax.inject.Inject
import javax.inject.Provider

class MainViewModel @Inject constructor(private val repository: MainRepository):ViewModel() {

    companion object{
        private const val TAG = "MainViewModel"
    }

    fun getObservableMovieList() = repository.getObservableMovieList()

    fun getTrendingMoviesFromApi(){
        repository.getTrendingMoviesFromApi()

    }
}
//out - any class that extending ViewModel class
//provider is value of map and class is key for map
class MainViewModelProviderFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T  = viewModels[modelClass]?.get() as T

}