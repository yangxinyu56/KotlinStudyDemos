package com.yxy.kotlinstudydemos.databinding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yxy.kotlinstudydemos.databinding.viewmodel.ViewModel


/**
 * Created by YangXinyu on 2017/7/19.<br>
 * 基于DataBinding的Fragment抽象基类
 */
abstract class BindingFragment<out VM : ViewModel, B : ViewDataBinding> : Fragment() {
    protected lateinit var mBinding: B
    protected val mViewModel by lazy { setupViewModel() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(setupLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = DataBindingUtil.bind(view)!!
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
