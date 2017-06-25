package com.yxy.kotlinstudydemos.adapter

import android.app.Activity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yxy.kotlinstudydemos.POJO.Forecast
import com.yxy.kotlinstudydemos.R

/**
 * Created by YangXinyu on 2017/6/18.
 */
class ForecastListAdapter(items: List<Forecast>, val context: Activity, layoutId: Int) : BaseQuickAdapter<Forecast, BaseViewHolder>(layoutId, items) {
    fun setLayout(layout_id: Int) {
        if (layout_id != 0) {
            mLayoutResId = layout_id
        }
    }

    override fun convert(helper: BaseViewHolder, item: Forecast) {
        val title = helper.getView<TextView>(R.id.tv_jp_title)
        val source = helper.getView<TextView>(R.id.tv_jp_source)
        val firstImg = helper.getView<ImageView>(R.id.iv_jp_firstImg)
        title.text = item.title
        source.text = "from:" + item.source
        Glide.with(context).load(item.firstImg).into(firstImg)
        //helper.addOnClickListener(R.id.iv_jp_firstImg)
    }

}