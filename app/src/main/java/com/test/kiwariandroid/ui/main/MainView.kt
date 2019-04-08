package com.test.kiwariandroid.ui.main

import com.test.kiwariandroid.base.BaseView
import com.test.kiwariandroid.data.model.DataItem

interface MainView : BaseView {
    fun onSuccess(list: List<DataItem>?)

}
