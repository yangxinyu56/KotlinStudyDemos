package com.yxy.kotlinstudydemos.ui.wxjx.di

import com.ylpw.ticketapp.global.AppComponent
import com.yxy.kotlinstudydemos.global.scope.ActivityScope
import com.yxy.kotlinstudydemos.ui.wxjx.WxjxPresenter
import dagger.Component

/**
 * Created by YangXinyu on 2017/7/1.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(WxjxModule::class))
interface WxjxComponent{
    fun getWxjxPresenter(): WxjxPresenter
}