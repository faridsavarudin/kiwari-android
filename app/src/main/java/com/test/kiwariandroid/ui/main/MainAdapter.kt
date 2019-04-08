package com.test.kiwariandroid.ui.main

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.test.kiwariandroid.R
import com.test.kiwariandroid.data.model.DataItem
import com.test.kiwariandroid.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.list_item.view.*

class MainAdapter(var list: List<DataItem>?, var context: Context)
    : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private lateinit var _context: Context
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        _context = context
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item, p0, false)
        )
    }

    override fun getItemCount(): Int = list?.size!!

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var data = list?.get(position)

        Glide.with(context!!).load(data?.image)
            .into(holder.imgProduct)

        holder.txtTitle.text = list?.get(position)?.name
        holder.txtPrice.text = list?.get(position)?.price.toString()
        holder.card.setOnClickListener {
            val intent = Intent(_context, DetailActivity::class.java)
            intent.putExtra("id", list?.get(position)?.id)
            _context.startActivity(intent)
        }

    }

    class MyViewHolder  (view: View) : RecyclerView.ViewHolder(view) {
        val imgProduct = view.img_product
        val txtTitle = view.txt_name
        val txtPrice = view.txt_price
        val card = view.card
    }
}