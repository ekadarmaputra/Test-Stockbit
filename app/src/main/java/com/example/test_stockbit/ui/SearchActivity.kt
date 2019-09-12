package com.example.test_stockbit.ui

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import com.example.test_stockbit.R
import com.example.test_stockbit.base.BaseActivity
import com.example.test_stockbit.ui.searchresult.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity: BaseActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        initLayout()
        initListener()
    }

    private fun initListener(){
        btnSearch.setOnClickListener(this)
    }

    private fun initLayout(){
        txtSearch.setOnEditorActionListener { _, actionId, event ->
            var handled = false

            if (actionId == EditorInfo.IME_ACTION_SEARCH
                || event != null && (event.keyCode == KeyEvent.KEYCODE_ENTER)){
                handled = true
            }

            return@setOnEditorActionListener handled
        }
    }

    override fun onClick(view: View?) {
        if (view == btnSearch){

            val movieName = txtSearch.text.toString()

            if (movieName.isNotEmpty()){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("movieName", movieName)
                startActivity(intent)
            } else {
                if (view != null) {
                    Snackbar.make(view, resources.getString(R.string.movie_not_found),
                        Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}