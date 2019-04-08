package com.test.kiwariandroid.data.remote

import com.test.kiwariandroid.data.model.BodyProduct
import com.test.kiwariandroid.data.model.ProductListResponse
import com.test.kiwariandroid.data.model.ProductResponse
import io.reactivex.Flowable
import retrofit2.http.*

interface ApiInterface {

    @GET("products")
    fun getProduct(): Flowable<ProductListResponse>

    @GET("products/{id}")
    fun getProductDetail(@Path("id") id : Int): Flowable<ProductResponse>

    @POST("products")
    fun addProducts(@Body bodyProduct: BodyProduct): Flowable<ProductResponse>

    @PUT("products/{id}")
    fun updateProduct(@Path("id")id: Int, @Body bodyProduct: BodyProduct): Flowable<ProductResponse>

    @DELETE("products/{id}")
    fun deleteProducts(@Path("id")id: Int): Flowable<ProductListResponse>
}
