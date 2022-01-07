package com.elf.kotlinroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Movies::class], version = 1)
abstract class MoviesDatabase: RoomDatabase() {

    abstract fun moviesDao() : MoviesDao

    companion object{
        private var movie : MoviesDatabase? = null

        fun moviesDatabase(context: Context): MoviesDatabase?{
            if(movie == null){
                movie = Room
                    .databaseBuilder(context, MoviesDatabase::class.java,"movie.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return movie
        }
    }
}