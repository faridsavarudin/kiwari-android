package com.test.kiwariandroid.utils

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

class CustomRecycler : RecyclerView {

    lateinit var mLinearLayoutManager: LinearLayoutManager

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    fun setUpList(){
        setHasFixedSize(true)
        mLinearLayoutManager = LinearLayoutManager(context)
        layoutManager = mLinearLayoutManager
    }

    fun setUpListHorizontal(context: Context?=null){
        setHasFixedSize(true)
        mLinearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        layoutManager = mLinearLayoutManager
    }
}