package com.yxy.kotlinstudydemos.fragments

import com.yxy.kotlinstudydemos.BR
import com.yxy.kotlinstudydemos.R
import com.yxy.kotlinstudydemos.databinding.BindingFragment
import com.yxy.kotlinstudydemos.databinding.FragmentMainBinding
import com.yxy.kotlinstudydemos.databinding.viewmodel.MainFragViewModel

/**
 * Created by YangXinyu on 2017/7/31.
 */
class MainFragment : BindingFragment<MainFragViewModel, FragmentMainBinding>() {
    override fun setupLayoutId(): Int = R.layout.fragment_main

    override fun setupViewModel(): MainFragViewModel = MainFragViewModel()

    override fun setupViewModelId(): Int = BR.viewModel

    override fun initView(binding: FragmentMainBinding) {

    }
}