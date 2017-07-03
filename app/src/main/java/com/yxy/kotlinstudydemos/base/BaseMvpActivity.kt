package com.ylpw.ticketapp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ylpw.ticketapp.global.AppComponent
import com.yxy.kotlinstudydemos.MyApplication

/**
 * Activity基类<br>
 * Created by YangXinyu on 2016/8/20.
 */

abstract class BaseMvpActivity<T : IPresenter> : AppCompatActivity(), IView<T> {
    lateinit protected var mPresenter: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getViewId())
        setPresenter(initPresenter(getAppComponent()))
    }

    private fun getAppComponent(): AppComponent {
        val myApplication = application as MyApplication
        return myApplication.getAppComponent()
    }

    override fun onStart() {
        super.onStart()
        mPresenter.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.destroy()
    }

    override fun setPresenter(presenter: T) {
        this.mPresenter = presenter
    }

    abstract fun getViewId(): Int
    abstract fun initPresenter(appComponent: AppComponent): T

}