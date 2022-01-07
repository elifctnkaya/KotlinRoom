package com.elf.kotlinroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elf.kotlinroom.database.Movies


class MovieAdapter(var movieList: ArrayList<Movies>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_recycler,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val textName = holder.itemView.findViewById<TextView>(R.id.textName)
        val textGenre = holder.itemView.findViewById<TextView>(R.id.textGenre)
        val textYear = holder.itemView.findViewById<TextView>(R.id.textYear)
        val textIMDB = holder.itemView.findViewById<TextView>(R.id.textIMDB)

        textName.text = "Movie Name: ${movieList[position].movieName}"
        textGenre.text = "Movie Genre: ${movieList[position].movieGenre}"
        textYear.text = "Movie Year: ${movieList[position].movieYear}"
        textIMDB.text = "Movie IMDB: ${movieList[position].movieIMDB}"
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    }
}