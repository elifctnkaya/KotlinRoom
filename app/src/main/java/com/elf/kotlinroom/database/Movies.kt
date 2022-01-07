package com.elf.kotlinroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "moviesTable")
data class Movies(
    @ColumnInfo(name = "movieName")
    var movieName: String,

    @ColumnInfo(name = "movieGenre")
    var movieGenre: String,

    @ColumnInfo(name = "movieYear")
    var movieYear: String,

    @ColumnInfo(name = "movieIMDB")
    var movieIMDB: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movieID")
    var movieID: Int = 0
}

