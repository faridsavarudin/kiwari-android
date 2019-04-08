package com.test.kiwariandroid.ui.detail

import android.util.Log
import com.test.kiwariandroid.base.BasePresenter
import com.test.kiwariandroid.data.model.BodyProduct
import com.test.kiwariandroid.data.model.ProductListResponse
import com.test.kiwariandroid.data.model.ProductResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber

class DetailPresenter(view: DetailView) : BasePresenter<DetailView>(){
    private val compositeDisposable = CompositeDisposable()
    init {
        super.attachView(view)
    }

    fun getProductDetail(id : Int){
        view!!.showProgressDialog()
        compositeDisposable.add(repositoryImpl.getProductDetail(id)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribeWith(object : ResourceSubscriber<ProductResponse>(){
                override fun onComplete() {

                }
                override fun onNext(t: ProductResponse?) {
                    view!!.dismissDialog()
                    view?.onSuccessDetail(t)
                }
                override fun onError(t: Throwable?) {
                    view!!.dismissDialog()
                    view!!.onFailed(t?.message!!)
                }

            })
        )
    }


    fun updateProducts(id : Int, bodyProduct: BodyProduct){
        view!!.showProgressDialog()
        compositeDisposable.add(repositoryImpl.updateProducts(id, bodyProduct)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribeWith(object : ResourceSubscriber<ProductResponse>(){
                override fun onComplete() {

                }
                override fun onNext(t: ProductResponse?) {
                    view!!.dismissDialog()
                    view?.onSuccessUpdate(t)
                }
                override fun onError(t: Throwable?) {
                    view!!.dismissDialog()
                    view!!.onFailed(t?.message!!)
                }

            })
        )
    }

    fun deleteProducts(id : Int){
        view!!.showProgressDialog()
        compositeDisposable.add(repositoryImpl.deleteProducts(id)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribeWith(object : ResourceSubscriber<ProductListResponse>(){
                override fun onComplete() {

                }
                override fun onNext(t: ProductListResponse?) {
                    Log.e("delete","delete")
                    view!!.dismissDialog()
                    view?.onSuccessDelete(t)
                }
                override fun onError(t: Throwable?) {
                    Log.e("delete","error"+t.toString())
                    Log.e("delete","error"+t?.message)
                    Log.e("delete","error"+t?.localizedMessage)
                    view!!.dismissDialog()
                    view!!.onFailed(t?.message!!)
                }

            })
        )
    }

}