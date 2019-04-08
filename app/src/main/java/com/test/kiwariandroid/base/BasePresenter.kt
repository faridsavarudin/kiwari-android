package com.test.kiwariandroid.base

import com.test.kiwariandroid.data.remote.ApiServices
import com.test.kiwariandroid.data.repository.RepositoryImpl
import com.test.kiwariandroid.utils.AppSchedulerProvider
import com.test.kiwariandroid.utils.SchedulerProvider

open class BasePresenter <V>{

    val service = ApiServices.getClient()
    val request = RepositoryImpl(service)
    val scheduler = AppSchedulerProvider()
    val repositoryImpl: RepositoryImpl = RepositoryImpl(service)
    val schedulerProvider: SchedulerProvider = scheduler


    var view: V? = null

    fun attachView(view: V) {
        this.view = view
    }

    fun deattachView() {
        this.view = null
    }
}