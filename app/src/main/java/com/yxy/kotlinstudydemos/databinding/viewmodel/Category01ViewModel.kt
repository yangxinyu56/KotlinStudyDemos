package com.yxy.kotlinstudydemos.databinding.viewmodel

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.yxy.kotlinstudydemos.BR
import com.yxy.kotlinstudydemos.R
import com.yxy.kotlinstudydemos.databinding.BindingRecyclerViewAdapter
import com.yxy.kotlinstudydemos.mapper.WeixingJingxuanMapper
import com.yxy.kotlinstudydemos.net.ForecastRequest
import org.jetbrains.anko.doAsyncResult

/**
 * Created by YangXinyu on 2017/7/31.
 */
class Category01ViewModel : ViewModel() {
    val datas = ArrayList<ItemWXJXViewModel>()
    val adapter = BindingRecyclerViewAdapter(datas, R.layout.item_weixin_jingxuan_list, BR.itemVM)
    val bindingAdapter = ObservableField(adapter)
    val isFinish = ObservableBoolean(false)

    fun requestWeixinJingxuan(pno: Int, ps: Int) {
        val forecastResult = doAsyncResult {
            isFinish.set(false)
            ForecastRequest(pno, ps).execute()
        }.get()
        isFinish.set(true)
        datas.addAll(WeixingJingxuanMapper().transform(forecastResult.result.list))
        adapter.notifyDataSetChanged()
    }
}