package com.example.lastmilecodechallengerxjavaretrofitmvvm.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lastmilecodechallengerxjavaretrofitmvvm.R
import com.example.lastmilecodechallengerxjavaretrofitmvvm.models.MovieResponse
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    companion object{

//        API Read Access Token (v4 auth)
//        eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1OTE3ZjJkZmY0OTVjZWRlMDg1OTE5NTZlMDY2ZmE1YyIsInN1YiI6IjVmNDQ3MTg4M2Y4ZWRlMDAzNGYwOTFjZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.LBJ7pCYHuP7gIa5oWbURCGtXC2t8IdujDmKq0qMyb_M
    }

    private lateinit var viewModel: MainViewModel
    @Inject
    lateinit var mainViewModelFactory:MainViewModelProviderFactory
    @Inject
    lateinit var mAdapterMovieList: AdapterMovieList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    private fun init() {
        //ViewModel
        viewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)
        //RecyclerView
        recycler_view_movie_list.adapter =mAdapterMovieList
        recycler_view_movie_list.layoutManager = LinearLayoutManager(this)

        viewModel.getTrendingMoviesFromApi()

        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.getObservableMovieList().observe(this, Observer<MovieResponse> {
            if(it != null){
                Toast.makeText(this@MainActivity, "${it?.results}", Toast.LENGTH_SHORT).show()
                mAdapterMovieList.setData(it.results)
            }
        })
    }
}