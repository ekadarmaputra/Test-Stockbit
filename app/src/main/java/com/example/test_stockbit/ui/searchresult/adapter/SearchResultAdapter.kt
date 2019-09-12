package com.example.test_stockbit.ui.searchresult.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test_stockbit.R
import com.example.test_stockbit.model.Movie
import com.example.test_stockbit.ui.searchresult.presenter.SearchResultRecyclerPresenter
import kotlinx.android.synthetic.main.card_movie_item.view.*

class SearchResultAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val presenter: SearchResultRecyclerPresenter =
        SearchResultRecyclerPresenter(ArrayList())
    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_movie_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return presenter.itemCount
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return presenter.onBindViewHolderAtPosition(holder as ViewHolder, position)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    fun updateResults(movieResults: ArrayList<Movie>){
        presenter.updateResult(movieResults)
        notifyDataSetChanged()
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun showMovieImage(url: String){
            Glide.with(itemView)
                .load(url)
                .into(itemView.imgPoster)
        }

        fun showMovieTitle(title: String){
            itemView.txtMovieTitle.text = title
        }

        fun showMovieYear(year: String){
            itemView.txtMovieYear.text = year
        }

        fun setClickedMovieItem(movie: Movie, position: Int){
            itemView.rootLayout.setOnClickListener { view ->
                if (listener != null){
                    view.tag = movie
                    listener?.onMovieItemClicked(view, position)
                }
            }
        }
    }

    interface OnItemClickListener{
        fun onMovieItemClicked(view: View, position: Int)
    }
}