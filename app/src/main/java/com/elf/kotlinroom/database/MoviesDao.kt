package com.elf.kotlinroom.database

import androidx.room.*

@Dao
interface MoviesDao {

    @Insert
    fun addMovie(movies: Movies)

   /*@Delete
    fun deleteMovie(movies: Movies)

    @Update
    fun updateMovie(movies: Movies)*/

    @Query("SELECT * FROM moviesTable")
    fun getAllMovies() : List<Movies>
}