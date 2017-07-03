package com.yxy.kotlinstudydemos

import android.app.Application
import com.ylpw.ticketapp.global.AppComponent
import com.ylpw.ticketapp.global.DaggerAppComponent
import com.ylpw.ticketapp.global.module.AppModule

/**
 * Created by YangXinyu on 2017/7/1.
 */
class MyApplication : Application() {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        initComponent()
    }

    private fun initComponent() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    fun getAppComponent(): AppComponent = appComponent
}