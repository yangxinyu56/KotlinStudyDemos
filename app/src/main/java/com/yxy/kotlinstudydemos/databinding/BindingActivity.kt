package com.yxy.kotlinstudydemos.databinding

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import com.yxy.kotlinstudydemos.databinding.viewmodel.ViewModel


/**
 * Created by YangXinyu on 2017/7/15.<br></br>
 * 基于DataBinding的Activity抽象基类
 */

abstract class BindingActivity<out VM : ViewModel, B : ViewDataBinding>(val mViewModel: VM, val mVariableId: Int, val mBinding: B) : AppCompatActivity() {

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.setVariable(mVariableId, mViewModel)
        initView(mBinding)
    }

    /**
     * 初始化UI
     * @param binding binding
     */
    abstract fun initView(binding: B)

}