package com.yxy.kotlinstudydemos.fragments

import com.yxy.kotlinstudydemos.BR
import com.yxy.kotlinstudydemos.R
import com.yxy.kotlinstudydemos.databinding.BindingFragment
import com.yxy.kotlinstudydemos.databinding.FragmentCategory03Binding
import com.yxy.kotlinstudydemos.databinding.viewmodel.Category03ViewModel

/**
 * Created by YangXinyu on 2017/8/1.<br>
 *   Tab3
 */
class Category03Fragment : BindingFragment<Category03ViewModel, FragmentCategory03Binding>() {
    override fun setupLayoutId(): Int = R.layout.fragment_category03

    override fun setupViewModel(): Category03ViewModel = Category03ViewModel()

    override fun setupViewModelId(): Int = BR.viewModel

    override fun initView(binding: FragmentCategory03Binding) {

    }
}