package com.yxy.kotlinstudydemos.net

import com.google.gson.Gson
import com.yxy.kotlinstudydemos.POJO.ForecastResult
import java.net.URL

/**
 * Created by YangXinyu on 2017/6/18.
 */
class ForecastRequest(val zipCode: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URLS = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val Complete_URL="http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa79722541"
        private val COMPLETE_URL = "$URLS&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(Complete_URL).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::
        class.java)
    }
}

