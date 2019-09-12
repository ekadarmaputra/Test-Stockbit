package com.example.test_stockbit.base

interface BasePresenter<T> {

    abstract fun attachView(view: T)

    abstract fun detachView()
}