package com.yxy.kotlinstudydemos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.yxy.kotlinstudydemos.POJO.Forecast
import com.yxy.kotlinstudydemos.adapter.ItemClickSupport
import com.yxy.kotlinstudydemos.adapter.MyDecoration
import com.yxy.kotlinstudydemos.adapter.SimplerItemAdapter
import com.yxy.kotlinstudydemos.net.ForecastRequest
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class ForecastsActivity : AppCompatActivity() {

    val appKey = "07dab151c4c70bc55bfc09205b0659a6"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecasts)
        val rlvWXJP = find<RecyclerView>(R.id.rlv_weixinjp)
        rlvWXJP.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        var items: List<Forecast>
        async {
            //异步执行发起请求
            val result = ForecastRequest(appKey).execute()
            uiThread {
                //请求完毕之后线程切换
                //Log.e("123456", result.result.toString())
                items = result.result.list
                rlvWXJP.adapter = SimplerItemAdapter(items, this@ForecastsActivity)
                rlvWXJP.addItemDecoration(MyDecoration(this@ForecastsActivity, MyDecoration.VERTICAL_LIST))
                ItemClickSupport.addTo(rlvWXJP).setOnItemClickListener { _, position, _ ->
                    val ine = Intent(this@ForecastsActivity, ForecastDetailActivity::class.java)
                    val b = Bundle()
                    b.putString("WEBVIEW_URL_KEY", items[position].url)
                    ine.putExtras(b)
                    startActivity(ine)
                    //toast(items[position].title) }
                }
            }
        }
    }
}
