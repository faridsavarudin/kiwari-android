package com.test.kiwariandroid.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.test.kiwariandroid.utils.DialogFactory

abstract class BaseActivity  <P : BasePresenter<*>>  : AppCompatActivity(), BaseView{

    protected var presenter : P? = null
    protected abstract fun createPresenter() : P
    private lateinit var progressDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()

        progressDialog = DialogFactory().createProgressDialog(this, "Loading")


    }

    override fun onDestroy() {
        super.onDestroy()
        if(presenter != null){
            presenter!!.deattachView()
        }
    }

    override fun showProgressDialog() {
        progressDialog.show()
    }

    override fun dismissDialog() {
        progressDialog.dismiss()
    }


}