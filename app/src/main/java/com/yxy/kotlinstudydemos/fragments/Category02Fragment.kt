package com.yxy.kotlinstudydemos.fragments

import com.yxy.kotlinstudydemos.BR
import com.yxy.kotlinstudydemos.R
import com.yxy.kotlinstudydemos.databinding.BindingFragment
import com.yxy.kotlinstudydemos.databinding.FragmentCategory02Binding
import com.yxy.kotlinstudydemos.databinding.viewmodel.Category02ViewModel

/**
 * Created by YangXinyu on 2017/8/1.<br>
 *   Tab2
 */
class Category02Fragment : BindingFragment<Category02ViewModel, FragmentCategory02Binding>() {
    override fun setupLayoutId(): Int = R.layout.fragment_category02

    override fun setupViewModel(): Category02ViewModel = Category02ViewModel()

    override fun setupViewModelId(): Int = BR.viewModel

    override fun initView(binding: FragmentCategory02Binding) {

    }
}