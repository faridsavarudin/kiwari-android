package com.test.kiwariandroid.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.kiwariandroid.utils.DialogFactory


/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 14, February, 2019
 */
abstract class BaseFragment  <P : BasePresenter<*>> : Fragment(), BaseView {

    protected var presenter : P? = null
    protected abstract fun createPresenter() : P
    private lateinit var progressDialog : ProgressDialog
    @LayoutRes
    abstract fun getLayout() : Int

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = createPresenter()

        progressDialog = DialogFactory().createProgressDialog(activity!!, "Loading")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (presenter != null) {
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