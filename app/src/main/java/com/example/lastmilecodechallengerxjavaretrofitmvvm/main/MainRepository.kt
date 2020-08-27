package com.example.lastmilecodechallengerxjavaretrofitmvvm.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.example.lastmilecodechallengerxjavaretrofitmvvm.api.Endpoint
import com.example.lastmilecodechallengerxjavaretrofitmvvm.models.Movie
import com.example.lastmilecodechallengerxjavaretrofitmvvm.models.MovieResponse
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainRepository(private val endpoint: Endpoint) {
    companion object {
        private const val TAG = "MainRepository"
    }

    private var trendingMovies = MediatorLiveData<MovieResponse>()

    fun getObservableMovieList() = trendingMovies

    fun getTrendingMoviesFromApi() {
        var source: LiveData<MovieResponse> = LiveDataReactiveStreams.fromPublisher(
            endpoint.getTrendingMovie()
                .subscribeOn(Schedulers.io())
        )
        trendingMovies.addSource(source) { t ->
            trendingMovies.value = t
            trendingMovies.removeSource(source)
        }

    }
}