package com.test.kiwariandroid.data.repository

import com.test.kiwariandroid.data.model.BodyProduct
import com.test.kiwariandroid.data.model.ProductListResponse
import com.test.kiwariandroid.data.model.ProductResponse
import io.reactivex.Flowable

interface Repository {
    fun getProduct () : Flowable<ProductListResponse>
    fun getProductDetail (id : Int) : Flowable<ProductResponse>
    fun updateProducts (id : Int, bodyProduct: BodyProduct) : Flowable<ProductResponse>
    fun deleteProducts (id : Int) : Flowable<ProductListResponse>
    fun addProducts (bodyProduct: BodyProduct) : Flowable<ProductResponse>
}