package com.yxy.kotlinstudydemos.net

import com.google.gson.Gson
import com.yxy.kotlinstudydemos.POJO.ForecastResult
import java.net.URL

/**
 * Created by YangXinyu on 2017/6/18.
 */
class ForecastRequest(pno: Int, ps: Int) {
    companion object {
        private val appKey = "07dab151c4c70bc55bfc09205b0659a6"
        private val URLS = "http://v.juhe.cn/weixin/query?"
    }

    val COMPLETE_URL = "$URLS+key=$appKey&pno=$pno&ps=$ps"

    fun execute(): ForecastResult = Gson().fromJson(URL(COMPLETE_URL).readText(), ForecastResult::class.java)

}

