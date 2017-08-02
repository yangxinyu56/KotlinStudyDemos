package com.yxy.kotlinstudydemos.databinding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yxy.kotlinstudydemos.databinding.viewmodel.ViewModel

/**
 * 简单的RecyclerView适配器<br>
 *     data//数据源
 *     layoutId//布局资源Id
 *     variableId//BR.xxx
 */
class BindingRecyclerViewAdapter<out T : ViewModel>(val data: List<T>, val layoutId: Int, val variableId: Int) : RecyclerView.Adapter<BindingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater
                .from(parent.context), layoutId, parent, false)
        val holder = BindingViewHolder(binding.root)
        holder.binding = binding
        return holder
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        holder.binding.setVariable(variableId, data[position])
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = data.size
}
