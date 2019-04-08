package com.test.kiwariandroid.ui.detail

import com.test.kiwariandroid.base.BaseView
import com.test.kiwariandroid.data.model.ProductListResponse
import com.test.kiwariandroid.data.model.ProductResponse

interface DetailView : BaseView {
    fun onSuccessDetail(data: ProductResponse?)
    fun onSuccessDelete(data: ProductListResponse?)
    fun onSuccessUpdate(data: ProductResponse?)

}