package com.yxy.kotlinstudydemos.databinding.viewmodel

import android.databinding.ObservableField

/**
 * Created by YangXinyu on 2017/7/31.
 */
class MainFragViewModel : ViewModel() {
   val title: ObservableField<String> = ObservableField("test_fragment")
}