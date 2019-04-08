package com.test.kiwariandroid.ui.add

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.test.kiwariandroid.R
import com.test.kiwariandroid.base.BaseActivity
import com.test.kiwariandroid.data.model.BodyProduct
import com.test.kiwariandroid.data.model.ProductResponse
import com.test.kiwariandroid.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : BaseActivity<AddPresenter>(), AddView {

    override fun createPresenter(): AddPresenter = AddPresenter(this)

    override fun onFailed(message: String) {
    }

    override fun onSuccessAdd(data: ProductResponse?) {
        Toast.makeText(this@AddActivity, data?.msg, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btn_add.setOnClickListener {
            if (!edt_name.text.toString().equals("")
                && !edt_price.text.toString().equals("")
                && !edt_image.text.toString().equals("")) {
                var bodyProduct = BodyProduct()
                bodyProduct.name = edt_name.text.toString()
                bodyProduct.price = edt_price.text.toString().toInt()
                bodyProduct.image = edt_image.text.toString()

                presenter?.addProducts(bodyProduct)
            }
        }

    }
}
