package com.example.test_stockbit.base

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity: DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}