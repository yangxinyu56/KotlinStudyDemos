package com.yxy.kotlinstudydemos.mapper

import com.yxy.kotlinstudydemos.POJO.Forecast
import com.yxy.kotlinstudydemos.databinding.viewmodel.ItemWXJXViewModel

/**
 * Created by YangXinyu on 2017/8/1.
 */
class WeixingJingxuanMapper {
    fun transform(forecasts: List<Forecast>) = forecasts.map {
        ItemWXJXViewModel(it.id, it.title, "from:${it.source}", it.firstImg, it.mark, it.url)
    }
}