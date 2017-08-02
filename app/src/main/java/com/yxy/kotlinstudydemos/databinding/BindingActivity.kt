package com.yxy.kotlinstudydemos.databinding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yxy.kotlinstudydemos.databinding.viewmodel.ViewModel


/**
 * Created by YangXinyu on 2017/7/15.<br></br>
 * 基于DataBinding的Activity抽象基类
 */

abstract class BindingActivity<out VM : ViewModel, B : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var mBinding: B
    protected val mViewModel by lazy { setupViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,setupLayoutId())
        mBinding.setVariable(setupViewModelId(), mViewModel)
        initView(mBinding)
    }

    /**
     * 设置xml布局文件
     * @return R.layout.fragment_xxx
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
     * @param binding mBinding
     */
    abstract fun initView(binding: B)

}