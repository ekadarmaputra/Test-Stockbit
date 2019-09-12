package com.example.test_stockbit.ui.launcher

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.test_stockbit.R
import com.example.test_stockbit.base.BaseActivity
import com.example.test_stockbit.ui.SearchActivity

class LauncherActivity: BaseActivity() {

    private val SPLASH_TIME_OUT = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        Handler().postDelayed({

            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)

            finish()
        }, SPLASH_TIME_OUT.toLong())
    }
}