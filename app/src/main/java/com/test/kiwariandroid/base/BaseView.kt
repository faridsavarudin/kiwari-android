package com.test.kiwariandroid.base

interface BaseView {

    fun showProgressDialog()
    fun dismissDialog()
    fun onFailed(message : String)

}