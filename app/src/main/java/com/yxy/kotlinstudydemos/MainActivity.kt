package com.yxy.kotlinstudydemos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.yxy.kotlinstudydemos.adapter.ItemClickSupport
import com.yxy.kotlinstudydemos.adapter.SimplerItemAdapter
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {


    val i = 12 // An Int
    val iHex = 0x0f // 一个十六进制的Int类型
    val l = 3L // A Long
    val d = 3.5 // A Double
    val f = 3.5F // A Float

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //view.setOnClickListener { toast("Hello world!") }
//        val forecastList = findViewById(R.id.rlv_forecast_list) as RecyclerView
        val forecastList = find<RecyclerView>(R.id.rlv_forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = SimplerItemAdapter(items)
        ItemClickSupport.addTo(forecastList).setOnItemClickListener { _, position, _ -> niceToast(items[position]) }
    }

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

    fun niceToast(message: String,
                  tag: String = javaClass.simpleName,
                  length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "$tag $message", length).show()
    }
}
