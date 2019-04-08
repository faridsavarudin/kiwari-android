package com.test.kiwariandroid.ui.main

import android.content.Intent
import android.os.Bundle
import com.test.kiwariandroid.R
import com.test.kiwariandroid.base.BaseActivity
import com.test.kiwariandroid.data.model.DataItem
import com.test.kiwariandroid.ui.add.AddActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    override fun createPresenter() = MainPresenter(this)

    override fun onFailed(message: String) {
    }

    override fun onSuccess(list: List<DataItem>?) {
        recycler.adapter = MainAdapter(list, this@MainActivity)
        recycler.setUpList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter?.getProducts()

        fab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }
}
