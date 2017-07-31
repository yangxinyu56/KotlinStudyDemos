package com.yxy.kotlinstudydemos.databinding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yxy.kotlinstudydemos.databinding.viewmodel.ViewModel


/**
 * Created by YangXinyu on 2017/7/19.<br>
 * 基于DataBinding的Fragment抽象基类
 */
abstract class BindingFragment<VM : ViewModel, B : ViewDataBinding> : Fragment() {
    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View {
        return inflater.inflate(setupLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)
        viewModel = setupViewModel()
        binding.setVariable(setupViewModelId(), viewModel)
        initView(binding)
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
     * @param binding binding
     */
    abstract fun initView(binding: B)

}
