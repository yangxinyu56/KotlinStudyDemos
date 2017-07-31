package com.yxy.kotlinstudydemos.databinding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import com.yxy.kotlinstudydemos.databinding.viewmodel.ViewModel


/**
 * Created by YangXinyu on 2017/7/15.<br></br>
 * 基于DataBinding的Activity抽象基类
 */

abstract class BindingActivity<VM : ViewModel, B : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, setupLayoutId())
        viewModel = setupViewModel()
        binding.setVariable(setupViewModelId(), viewModel)
        initView(binding)
    }

    /**
     * 设置xml布局文件
     * @return R.layout.activity_xxx
     */
    abstract fun setupLayoutId(): Int

    /**
     * 设置ViewModel,即xml布局文件中data节点里<'variable type="xxx.xxx.ViewModel">
     * @return Activity对应的ViewModel
     */
    abstract fun setupViewModel(): VM

    /**
     * 设置ViewModel的Id,即xml布局文件中data节点里<'variable name="xxx">
     * @return BR.xxx
     */
    abstract fun setupViewModelId(): Int

    /**
     * 初始化UI
     * @param binding binding
     */
    abstract fun initView(binding: B)

}