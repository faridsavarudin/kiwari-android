package com.test.kiwariandroid.ui.main

import com.test.kiwariandroid.base.BasePresenter
import com.test.kiwariandroid.data.model.ProductListResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber


class MainPresenter(view: MainView) : BasePresenter<MainView>(){

    private val compositeDisposable = CompositeDisposable()
    init {
        super.attachView(view)
    }

    fun getProducts(){
        view!!.showProgressDialog()
        compositeDisposable.add(repositoryImpl.getProduct()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribeWith(object : ResourceSubscriber<ProductListResponse>(){
                override fun onComplete() {

                }
                override fun onNext(t: ProductListResponse?) {
                    view!!.dismissDialog()
                    view?.onSuccess(t?.data)
                }
                override fun onError(t: Throwable?) {
                    view!!.dismissDialog()
                    view!!.onFailed(t?.message!!)
                }

            })
        )
    }

}