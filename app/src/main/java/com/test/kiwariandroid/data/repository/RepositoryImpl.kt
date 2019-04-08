package com.test.kiwariandroid.data.repository

import com.test.kiwariandroid.data.model.BodyProduct
import com.test.kiwariandroid.data.model.ProductListResponse
import com.test.kiwariandroid.data.model.ProductResponse
import com.test.kiwariandroid.data.remote.ApiInterface
import io.reactivex.Flowable


class RepositoryImpl (private val apiInterface: ApiInterface) : Repository {

    override fun addProducts(bodyProduct: BodyProduct): Flowable<ProductResponse> = apiInterface.addProducts(bodyProduct)

    override fun getProductDetail(id: Int): Flowable<ProductResponse> =apiInterface.getProductDetail(id)

    override fun updateProducts(id: Int, bodyProduct: BodyProduct): Flowable<ProductResponse> = apiInterface.updateProduct(id, bodyProduct)

    override fun deleteProducts(id: Int): Flowable<ProductListResponse> = apiInterface.deleteProducts(id)

    override fun getProduct(): Flowable<ProductListResponse> = apiInterface.getProduct()

}