package com.yxy.kotlinstudydemos.adapter

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.yxy.kotlinstudydemos.POJO.Forecast
import com.yxy.kotlinstudydemos.R

/**
 * Created by YangXinyu on 2017/6/19.
 */

class SimplerItemAdapter(val dateItems: List<Forecast>,val context: Activity) : RecyclerView.Adapter<SimplerItemAdapter.SimpleItemViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SimpleItemViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_forecast, viewGroup, false)
        return SimpleItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: SimpleItemViewHolder, position: Int) {
        val f :Forecast= dateItems[position]
        viewHolder.tvTitle.text = f.title
        viewHolder.tvFrom.text = f.source
        Glide.with(context).load(f.firstImg).into(viewHolder.ivFirstImg)
    }

    override fun getItemCount(): Int =dateItems.size

    class SimpleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_jp_title) as TextView
        var tvFrom: TextView = itemView.findViewById(R.id.tv_jp_source) as TextView
        var ivFirstImg: ImageView = itemView.findViewById(R.id.iv_jp_firstImg) as ImageView
    }
}
