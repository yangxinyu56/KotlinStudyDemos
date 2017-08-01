package com.yxy.kotlinstudydemos.databinding.viewmodel

import android.databinding.ObservableField
import com.yxy.kotlinstudydemos.fragments.MainFragment

/**
 * Created by YangXinyu on 2017/7/31.
 */
class MainFragViewModel : ViewModel() {
    val vpAdapter = ObservableField<MainFragment.MyViewPagerAdapter>()
}