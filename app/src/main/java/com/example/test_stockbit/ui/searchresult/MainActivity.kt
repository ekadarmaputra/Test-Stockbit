package com.example.test_stockbit.ui.searchresult

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.test_stockbit.R
import com.example.test_stockbit.base.BaseActivity
import com.example.test_stockbit.model.Movie
import com.example.test_stockbit.ui.moviedetail.MovieDetailActivity
import com.example.test_stockbit.ui.searchresult.adapter.SearchResultAdapter
import com.example.test_stockbit.ui.searchresult.contract.SearchResultContract
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(),
    SearchResultContract.View,
    SearchResultAdapter.OnItemClickListener
{
    @Inject
    lateinit var presenter: SearchResultContract.Presenter

    private var searchResultAdapter: SearchResultAdapter =
        SearchResultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)

        initRecyclerView()
        initListener()

        handleIntent(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    private fun handleIntent(intent: Intent){
        val movieName: String? = intent.getStringExtra("movieName")
        presenter.loadSearchResult(movieName?:"")
    }

    private fun initListener(){
        searchResultAdapter.setOnItemClickListener(this)
    }

    private fun initRecyclerView(){
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        rvSearchResult.apply {
            itemAnimator = DefaultItemAnimator()
            layoutManager = staggeredGridLayoutManager
            adapter = searchResultAdapter
        }
    }

    override fun showSearchResult(movieResults:ArrayList<Movie>) {
        searchResultAdapter.updateResults(movieResults)
    }

    override fun onMovieItemClicked(view: View, position: Int) {
        val movie = view.tag as Movie
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("movieId", movie.imdbID)
        startActivity(intent)
    }

    override fun showProgress() {
        loader.visibility = View.VISIBLE
        rvSearchResult.visibility = View.GONE
    }

    override fun showProgressCompleted() {
        loader.visibility = View.GONE
        rvSearchResult.visibility = View.VISIBLE
    }


    override fun showErrorMessage(message: String) {

    }
}
