package com.elf.kotlinroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elf.kotlinroom.database.Movies
import com.elf.kotlinroom.database.MoviesDatabase

class MoviesActivity : AppCompatActivity() {

    private lateinit var movieList: ArrayList<Movies>
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var moviesDatabase: MoviesDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        moviesDatabase = MoviesDatabase.moviesDatabase(this)!!

        recyclerView = findViewById(R.id.recyclerView)
        movieList = ArrayList()

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        movieAdapter = MovieAdapter(movieList)
        recyclerView.adapter = movieAdapter

        showAllMovies()
    }

    private fun showAllMovies(){
        movieList.clear()
        val mList = moviesDatabase.moviesDao().getAllMovies()
        for (i in mList){
            movieList.add(i)
        }
        movieAdapter.notifyDataSetChanged()
    }
}