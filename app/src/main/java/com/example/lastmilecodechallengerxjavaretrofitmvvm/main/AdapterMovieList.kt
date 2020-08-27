package com.example.lastmilecodechallengerxjavaretrofitmvvm.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.lastmilecodechallengerxjavaretrofitmvvm.databinding.RowMovieListBinding
import com.example.lastmilecodechallengerxjavaretrofitmvvm.models.Movie

class AdapterMovieList: RecyclerView.Adapter<AdapterMovieList.MyViewHolder>() {

    companion object{
        private const val TAG = "AdapterMovieList"
    }

    private var mList = ArrayList<Movie>()

    inner class MyViewHolder(private val binding:RowMovieListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(movie:Movie){
            binding.item = movie
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowMovieListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val layoutParams = RecyclerView.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        binding.root.layoutParams = layoutParams
        return MyViewHolder(binding)
    }

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(mList[position])
    }

    fun setData(list:ArrayList<Movie>){
        mList = list
        notifyDataSetChanged()
        Log.d(TAG, "setData: ${mList.size}")
    }
}