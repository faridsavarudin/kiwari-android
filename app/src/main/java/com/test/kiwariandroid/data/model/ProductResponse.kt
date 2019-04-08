package com.test.kiwariandroid.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: DataItem? = null
)