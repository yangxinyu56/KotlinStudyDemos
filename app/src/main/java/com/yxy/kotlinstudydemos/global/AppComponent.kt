package com.ylpw.ticketapp.global

import android.content.Context
import com.ylpw.ticketapp.global.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * 全局组件<br>
 * Created by YangXinyu on 2017/6/30.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun getContext(): Context
}