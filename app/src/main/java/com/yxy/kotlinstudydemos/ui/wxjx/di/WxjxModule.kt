package com.yxy.kotlinstudydemos.ui.wxjx.di

import com.yxy.kotlinstudydemos.global.scope.ActivityScope
import com.yxy.kotlinstudydemos.ui.wxjx.WxjxActivity
import dagger.Module
import dagger.Provides

/**
 * Created by YangXinyu on 2017/7/1.
 */
@Module
class WxjxModule(val context:WxjxActivity){
    @Provides @ActivityScope fun provideWxjxView()=context
}