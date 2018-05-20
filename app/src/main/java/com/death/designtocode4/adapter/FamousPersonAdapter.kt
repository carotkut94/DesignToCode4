package com.death.designtocode4.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.death.designtocode4.R
import com.death.designtocode4.model.person.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_movie.view.*

class FamousPersonAdapter(private val movieList: List<ResultsItem?>?, private val context: Context) : RecyclerView.Adapter<FamousPersonAdapter.CustomViewHolder>() {

    val ROOT_IMAGE_URL = "https://image.tmdb.org/t/p/original"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.single_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList!!.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val singleMovie = movieList?.get(position)
        holder.personName.text = singleMovie?.name
        Picasso.get().load(ROOT_IMAGE_URL+singleMovie?.profilePath).fit().into(holder.personPhoto)
    }

    class CustomViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val personName = view.movie_name
        val personPhoto = view.poster
    }


}