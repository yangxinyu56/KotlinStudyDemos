package com.yxy.kotlinstudydemos.databinding

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View


/**
 * 简单的RecyclerViewViewHolder
 */
class BindingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var binding: ViewDataBinding
}