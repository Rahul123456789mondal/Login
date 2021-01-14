package com.example.login.adapter;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arka.android.androidapplication.data.model.response.product.ProductResponseData
import com.bumptech.glide.Glide
import com.example.login.R

class RecyclerProductAdapter(val context: Context ,private val dataList: List<ProductResponseData>) : RecyclerView.Adapter<RecyclerProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.itemrow, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val data = dataList[position]
        viewHolder.textView1.text = data.slug
        viewHolder.textView2.text = data.catName
        Glide.with(context).load("https://digitalwebgurukul.com/projects/localway/uploads/"+data.image2).into(viewHolder.image)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView1 = itemView.findViewById<TextView>(R.id.textView)
        var textView2 = itemView.findViewById<TextView>(R.id.textView2)
        var image = itemView.findViewById<ImageView>(R.id.imageView)
    }

}