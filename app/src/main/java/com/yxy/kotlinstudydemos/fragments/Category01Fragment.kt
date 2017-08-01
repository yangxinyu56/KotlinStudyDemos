package com.yxy.kotlinstudydemos.fragments

import android.databinding.Observable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.yxy.kotlinstudydemos.BR
import com.yxy.kotlinstudydemos.R
import com.yxy.kotlinstudydemos.databinding.BindingFragment
import com.yxy.kotlinstudydemos.databinding.FragmentCategory01Binding
import com.yxy.kotlinstudydemos.databinding.viewmodel.Category01ViewModel
import kotlinx.android.synthetic.main.fragment_category01.*


/**
 * Created by YangXinyu on 2017/8/1.<br>
 *   微信精选
 */
class Category01Fragment : BindingFragment<Category01ViewModel, FragmentCategory01Binding>() {
    var pageNo: Int = 1
    val pageSize: Int = 20
    override fun setupLayoutId(): Int = R.layout.fragment_category01

    override fun setupViewModel(): Category01ViewModel = Category01ViewModel()

    override fun setupViewModelId(): Int = BR.viewModel

    override fun initView(binding: FragmentCategory01Binding) {
        binding.rcvWxjxRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.requestWeixinJingxuan(pageNo, pageSize)

        setupRefreshLayoutListener(refreshLayout)

        //viewModel的字段值变化监听回调
        viewModel.isFinish.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable, propertyId: Int) {
                if (viewModel.isFinish.get()) {//告诉SmartRefreshLayout刷新或加载完成
                    if (pageNo == 1) refreshLayout.finishRefresh() else refreshLayout.finishLoadmore()
                }
            }
        })
    }

    fun setupRefreshLayoutListener(refreshLayout: SmartRefreshLayout) {
        refreshLayout.setOnRefreshListener {
            pageNo = 1
            viewModel.datas.clear()
            viewModel.requestWeixinJingxuan(pageNo, pageSize)
        }
        refreshLayout.setOnLoadmoreListener {
            viewModel.requestWeixinJingxuan(++pageNo, pageSize)
        }
    }
}