package com.ylpw.ticketapp.global.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by YangXinyu on 2017/7/1.
 */
@Module(includes = arrayOf(ApiModule::class))
class AppModule(val context: Context) {
    @Singleton @Provides fun provideContext(): Context = context
}
