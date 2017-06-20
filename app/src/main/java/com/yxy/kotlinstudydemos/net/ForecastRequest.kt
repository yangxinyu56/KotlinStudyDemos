package com.yxy.kotlinstudydemos.net

import com.google.gson.Gson
import com.yxy.kotlinstudydemos.POJO.ForecastResult
import java.net.URL

/**
 * Created by YangXinyu on 2017/6/18.
 */
class ForecastRequest(val appKey: String) {
    companion object {
        //private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URLS = "http://v.juhe.cn/weixin/query?"
        //private val Complete_URL="http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa79722541"
        private val COMPLETE_URL = "$URLS+key="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + appKey).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::
        class.java)
    }
}

