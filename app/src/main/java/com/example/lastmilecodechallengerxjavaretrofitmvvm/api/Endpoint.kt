package com.example.lastmilecodechallengerxjavaretrofitmvvm.api

import com.example.lastmilecodechallengerxjavaretrofitmvvm.models.Movie
import com.example.lastmilecodechallengerxjavaretrofitmvvm.models.MovieResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    @GET("trending/movie/day?api_key=5917f2dff495cede08591956e066fa5c")
    fun getTrendingMovie(): Flowable<MovieResponse>
}