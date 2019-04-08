package com.test.kiwariandroid.ui.add

import com.test.kiwariandroid.base.BasePresenter
import com.test.kiwariandroid.data.model.BodyProduct
import com.test.kiwariandroid.data.model.ProductResponse
import com.test.kiwariandroid.ui.detail.DetailView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber

class AddPresenter(view: AddView) : BasePresenter<AddView>() {
    private val compositeDisposable = CompositeDisposable()

    init {
        super.attachView(view)
    }

    fun addProducts(bodyProduct: BodyProduct) {
        view!!.showProgressDialog()
        compositeDisposable.add(
            repositoryImpl.addProducts(bodyProduct)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeWith(object : ResourceSubscriber<ProductResponse>() {
                    override fun onComplete() {

                    }

                    override fun onNext(t: ProductResponse?) {
                        view!!.dismissDialog()
                        view?.onSuccessAdd(t)
                    }

                    override fun onError(t: Throwable?) {
                        view!!.dismissDialog()
                        view!!.onFailed(t?.message!!)
                    }

                })
        )
    }
}