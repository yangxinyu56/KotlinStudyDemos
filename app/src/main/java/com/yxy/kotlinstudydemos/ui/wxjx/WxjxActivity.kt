package com.yxy.kotlinstudydemos.ui.wxjx

import com.ylpw.ticketapp.base.BaseMvpActivity
import com.ylpw.ticketapp.global.AppComponent
import com.yxy.kotlinstudydemos.POJO.Forecast
import com.yxy.kotlinstudydemos.R
import com.yxy.kotlinstudydemos.ui.wxjx.di.WxjxModule

/**
 * Created by YangXinyu on 2017/7/1.
 */
class WxjxActivity: BaseMvpActivity<WxjxContract.Presenter>(),WxjxContract.View{
    override fun showData(list: List<Forecast>) {
        //xianshi
    }

    override fun getViewId(): Int {
        return R.layout.activity_forecasts
    }

    override fun initPresenter(appComponent: AppComponent): WxjxContract.Presenter {
        return DaggerWxjxComponent
                .builder()
                .appComponent(appComponent)
                .WxjxModule(WxjxModule(this))
                .build()
                .getPresent()
    }

}