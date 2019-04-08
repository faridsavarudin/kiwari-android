package com.test.kiwariandroid.ui.detail

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.test.kiwariandroid.R
import com.test.kiwariandroid.base.BaseActivity
import com.test.kiwariandroid.data.model.BodyProduct
import com.test.kiwariandroid.data.model.ProductListResponse
import com.test.kiwariandroid.data.model.ProductResponse
import com.test.kiwariandroid.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity<DetailPresenter>(), DetailView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var id = intent.getIntExtra("id", 0)
        presenter?.getProductDetail(id)

        btn_hapus.setOnClickListener {
            presenter?.deleteProducts(id)
        }

        btn_edit.setOnClickListener {
            var bodyProduct = BodyProduct()

            bodyProduct.name = edt_name.text.toString()
            bodyProduct.price = edt_price.text.toString().toInt()
            bodyProduct.image = edt_image.text.toString()

            presenter?.updateProducts(id, bodyProduct)
        }
    }

    override fun createPresenter() = DetailPresenter(this@DetailActivity)


    override fun onFailed(message: String) {
    }

    override fun onSuccessDetail(data: ProductResponse?) {
        edt_name.setText(data?.data?.name)
        edt_price.setText(data?.data?.price.toString())
        edt_image.setText(data?.data?.image)
        Glide.with(this@DetailActivity)
            .load(data?.data?.image)
            .asBitmap()
            .into(img_product)
    }

    override fun onSuccessDelete(data: ProductListResponse?) {
        Toast.makeText(this@DetailActivity, data?.msg, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    override fun onSuccessUpdate(data: ProductResponse?) {
        Toast.makeText(this@DetailActivity, data?.msg, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}
