package com.example.lastmilecodechallengerxjavaretrofitmvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun ImageView.loadImage(path:String){
    Glide.with(this).load(Constants.IMAGE_LOAD_URL + path).centerCrop().into(this)
}