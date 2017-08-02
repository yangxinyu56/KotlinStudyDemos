package com.yxy.kotlinstudydemos.fragments

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.yxy.kotlinstudydemos.BR
import com.yxy.kotlinstudydemos.R
import com.yxy.kotlinstudydemos.databinding.BindingFragment
import com.yxy.kotlinstudydemos.databinding.FragmentMainBinding
import com.yxy.kotlinstudydemos.databinding.viewmodel.MainFragViewModel
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by YangXinyu on 2017/7/31.
 */
class MainFragment : BindingFragment<MainFragViewModel, FragmentMainBinding>() {
    override fun setupLayoutId() = R.layout.fragment_main

    override fun setupViewModel() = MainFragViewModel()

    override fun setupViewModelId() = BR.viewModel

    override fun initView(binding: FragmentMainBinding) {
        val stringArray = resources.getStringArray(R.array.home_catalog_name)
        mViewModel.vpAdapter.set(MyViewPagerAdapter(childFragmentManager, initFragments(), stringArray))
        tl_main_category_tabs.setupWithViewPager(vp_main_category)
    }

    private fun initFragments(): List<Fragment> {
        val tab1 = Category01Fragment()
        val tab2 = Category02Fragment()
        val tab3 = Category03Fragment()
        return listOf<Fragment>(tab1, tab2, tab3)
    }

    inner class MyViewPagerAdapter(fm: FragmentManager, val mFragments: List<Fragment>, val titles: Array<String>) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int) = mFragments[position]

        override fun getCount() = mFragments.size

        override fun getPageTitle(position: Int) = titles[position]
    }
}