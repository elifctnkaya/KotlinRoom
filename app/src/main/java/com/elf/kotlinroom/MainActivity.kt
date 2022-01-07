package com.elf.kotlinroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elf.kotlinroom.database.Movies
import com.elf.kotlinroom.database.MoviesDatabase
import com.elf.kotlinroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var moviesDatabase: MoviesDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        moviesDatabase = MoviesDatabase.moviesDatabase(this)!!


        binding.buttonAdd.setOnClickListener {
            moviesAdd()
        }

        binding.buttonGoToMovies.setOnClickListener {
            val intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun moviesAdd() {
        val movieName = binding.movieName.text.toString()
        val movieGenre = binding.movieGenre.text.toString()
        val movieYear = binding.movieYear.text.toString()
        val movieIMDB = binding.movieIMDB.text.toString()

        if (movieName != "" || movieGenre != "" || movieYear != "" || movieIMDB != "") {
            moviesDatabase.moviesDao()
                .addMovie(Movies(movieName, movieGenre, movieYear, movieIMDB))
            val intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}