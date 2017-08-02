package com.yxy.kotlinstudydemos.fragments

import android.content.Intent
import android.databinding.Observable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.yxy.kotlinstudydemos.BR
import com.yxy.kotlinstudydemos.C
import com.yxy.kotlinstudydemos.R
import com.yxy.kotlinstudydemos.WebActivity
import com.yxy.kotlinstudydemos.adapter.ItemClickSupport
import com.yxy.kotlinstudydemos.databinding.BindingFragment
import com.yxy.kotlinstudydemos.databinding.FragmentCategory01Binding
import com.yxy.kotlinstudydemos.databinding.viewmodel.Category01ViewModel
import kotlinx.android.synthetic.main.fragment_category01.*


/**
 * Created by YangXinyu on 2017/8/1.<br>
 *   微信精选
 */
class Category01Fragment : BindingFragment<Category01ViewModel, FragmentCategory01Binding>(), ItemClickSupport.OnItemClickListener {
    var pageNo = 1
    val pageSize = 20
    override fun setupLayoutId() = R.layout.fragment_category01

    override fun setupViewModel() = Category01ViewModel()

    override fun setupViewModelId() = BR.viewModel

    override fun initView(binding: FragmentCategory01Binding) {
        binding.rcvWxjxRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        ItemClickSupport.addTo(binding.rcvWxjxRecycler).setOnItemClickListener(this)
    }

    override fun onItemClicked(recyclerView: RecyclerView?, position: Int, v: View?) {
        val inn = Intent(activity, WebActivity::class.java)
        inn.putExtra(C.intent.web_info, mViewModel.adapter.data[position].url)
        startActivity(inn)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.requestWeixinJingxuan(pageNo, pageSize)

        setupRefreshLayoutListener(refreshLayout)

        //viewModel的字段值变化监听回调
        setupViewModelChangedCallback(mViewModel)
    }

    fun setupViewModelChangedCallback(viewModel: Category01ViewModel) {
        viewModel.isFinish.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable, propertyId: Int) {
                if (mViewModel.isFinish.get()) {//告诉SmartRefreshLayout刷新或加载完成
                    if (pageNo == 1) refreshLayout.finishRefresh() else refreshLayout.finishLoadmore()
                }
            }
        })
    }

    fun setupRefreshLayoutListener(refreshLayout: SmartRefreshLayout) {
        refreshLayout.setOnRefreshListener {
            pageNo = 1
            mViewModel.datas.clear()
            mViewModel.requestWeixinJingxuan(pageNo, pageSize)
        }
        refreshLayout.setOnLoadmoreListener {
            mViewModel.requestWeixinJingxuan(++pageNo, pageSize)
        }
    }
}