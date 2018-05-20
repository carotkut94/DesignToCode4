package com.death.designtocode4.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.death.designtocode4.R
import com.death.designtocode4.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_watch_movie.view.*
import android.widget.ImageView
import android.widget.TextView
import jp.wasabeef.picasso.transformations.BlurTransformation


class WatchAdapter(private val movieList: List<ResultsItem?>?, private val context: Context) : RecyclerView.Adapter<WatchAdapter.CustomViewHolder>() {

    val ROOT_IMAGE_URL = "https://image.tmdb.org/t/p/w780"
    val ROOT_POSTER_URL = "https://image.tmdb.org/t/p/original"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.single_watch_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList!!.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val singleMovie = movieList?.get(position)
        holder.movieName.text = singleMovie?.title
        Picasso.get().load(ROOT_IMAGE_URL+singleMovie?.backdropPath).transform(BlurTransformation(context)).fit().into(holder.movieBackdrop)
        Picasso.get().load(ROOT_IMAGE_URL+singleMovie?.posterPath).fit().into(holder.moviePoster)
        holder.rating.text = singleMovie?.voteAverage.toString()
    }

    class CustomViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val movieName: TextView = view.movie_name_backdrop
        val movieBackdrop: ImageView = view.backdrop
        val moviePoster: ImageView = view.poster_image
        val rating: TextView = view.rating
    }


}