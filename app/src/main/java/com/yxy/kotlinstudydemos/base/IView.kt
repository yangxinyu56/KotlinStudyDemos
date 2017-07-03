package com.ylpw.ticketapp.base

/**
 * Created by YangXinyu on 2017/6/30.
 */
interface IView<in T : IPresenter> {
    fun setPresenter(presenter: T)
}
