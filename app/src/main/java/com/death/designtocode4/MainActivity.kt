package com.death.designtocode4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.death.designtocode4.adapter.FamousPersonAdapter
import com.death.designtocode4.adapter.TopAdapter
import com.death.designtocode4.adapter.WatchAdapter
import com.death.designtocode4.model.MovieResponse
import com.death.designtocode4.model.person.FamousPerson
import com.rw.velocity.Velocity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val URL_TOP = "https://api.themoviedb.org/3/movie/top_rated?api_key=56196b3d62369c56461e48dcf3652bf0&language=en-US&page=1"
    val URL_UPCOMING = "https://api.themoviedb.org/3/movie/upcoming?api_key=56196b3d62369c56461e48dcf3652bf0&language=en-US&page=1"
    val URL_FAMOUS = "https://api.themoviedb.org/3/person/popular?api_key=56196b3d62369c56461e48dcf3652bf0&language=en-US&page=1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Velocity.initialize(3)
        loadMovies()
    }

    fun loadMovies()
    {
        Velocity.get(URL_TOP).connect(object : Velocity.ResponseListener{
            override fun onVelocitySuccess(p0: Velocity.Response?) {
                val movieResponse = p0!!.deserialize(MovieResponse::class.java)
                top_movies.adapter = TopAdapter(movieResponse.results,this@MainActivity)
                top_movies.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL,false)
            }

            override fun onVelocityFailed(p0: Velocity.Response?) {

            }
        })

        Velocity.get(URL_UPCOMING).connect(object : Velocity.ResponseListener{
            override fun onVelocitySuccess(p0: Velocity.Response?) {
                val movieResponse = p0!!.deserialize(MovieResponse::class.java)
                upcoming_movies.adapter = WatchAdapter(movieResponse.results,this@MainActivity)
                upcoming_movies.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL,false)
            }

            override fun onVelocityFailed(p0: Velocity.Response?) {

            }
        })
        Velocity.get(URL_FAMOUS).connect(object : Velocity.ResponseListener{
            override fun onVelocitySuccess(p0: Velocity.Response?) {
                val movieResponse = p0!!.deserialize(FamousPerson::class.java)
                famous.adapter = FamousPersonAdapter(movieResponse.results,this@MainActivity)
                famous.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL,false)
            }

            override fun onVelocityFailed(p0: Velocity.Response?) {

            }
        })
    }
}
