package com.yxy.kotlinstudydemos.ui.wxjx

import com.ylpw.ticketapp.base.IPresenter
import com.ylpw.ticketapp.base.IView
import com.yxy.kotlinstudydemos.POJO.Forecast

/**
 * Created by YangXinyu on 2017/7/1.
 */
interface WxjxContract {
    interface Presenter:IPresenter{
        fun loadData(pageNo:Int,pageSize:Int)
    }
    interface View:IView<Presenter>{
        fun showData(list: List<Forecast>)
    }
}
