package com.ylpw.ticketapp.global.module

import com.ylpw.ticketapp.data.api.WxjxApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by YangXinyu on 2017/7/1.
 */
@Module(includes = arrayOf(RetrofitModule::class))
class ApiModule {
    @Provides @Singleton fun provideWxjxApi(retrofit: Retrofit): WxjxApi = retrofit.create<WxjxApi>(WxjxApi::class.java)
}
