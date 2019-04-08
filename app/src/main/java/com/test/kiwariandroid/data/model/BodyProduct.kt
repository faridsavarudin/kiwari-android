package com.test.kiwariandroid.data.model

import com.google.gson.annotations.SerializedName

data class BodyProduct(

	@field:SerializedName("image")
	var image: String? = null,

	@field:SerializedName("price")
	var price: Int? = null,

	@field:SerializedName("name")
    var name: String? = null
)