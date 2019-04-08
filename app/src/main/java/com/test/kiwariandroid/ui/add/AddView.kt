package com.test.kiwariandroid.ui.add

import com.test.kiwariandroid.base.BaseView
import com.test.kiwariandroid.data.model.ProductResponse

interface AddView : BaseView {
    fun onSuccessAdd(data: ProductResponse?)
}