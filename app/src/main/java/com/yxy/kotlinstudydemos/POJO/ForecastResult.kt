package com.yxy.kotlinstudydemos.POJO

/**
 * Created by YangXinyu on 2017/6/18.
 */
data class ForecastResult(val reason: String, val result: Result,val error_code:Int)
data class Result(val list: List<Forecast>, val totalPage: Int,val ps:Int,val pno:Int)
data class Forecast(val id: String, val title: String, val source: String,
                    val firstImg: String, val mark: String, val url: String)