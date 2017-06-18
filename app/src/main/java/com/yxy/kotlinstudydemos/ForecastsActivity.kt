package com.yxy.kotlinstudydemos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.yxy.kotlinstudydemos.net.ForecastRequest
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

class ForecastsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecasts)
//        async {
//            ForecastRequest("Beijing").run()
//            uiThread { longToast("Request performed") }
//        }
        async{   //异步执行发起请求
            val result= ForecastRequest("Beijing").execute()
            uiThread {  //请求完毕之后线程切换
                Log.e("123456", result.city.name)
            }
        }
    }
}
