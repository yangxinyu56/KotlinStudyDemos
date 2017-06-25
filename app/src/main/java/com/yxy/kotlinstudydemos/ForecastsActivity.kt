package com.yxy.kotlinstudydemos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.chad.library.adapter.base.BaseQuickAdapter
import com.yxy.kotlinstudydemos.POJO.ForecastResult
import com.yxy.kotlinstudydemos.adapter.ForecastListAdapter
import com.yxy.kotlinstudydemos.net.ForecastRequest
import kotlinx.android.synthetic.main.activity_forecasts.*
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.find

class ForecastsActivity : AppCompatActivity(), BaseQuickAdapter.RequestLoadMoreListener {
    var pageNo: Int = 1
    val pageSize: Int = 20
    lateinit var mAdapter: ForecastListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecasts)
        initActionBar(R.id.tb_weixinjp)
        initAdapter()
        rlv_weixinjp.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        requestData(pageNo, pageSize)
        rrl_weixinjp.setOnRefreshListener {
            pageNo = 1
            requestData(pageNo, pageSize)
        }
    }

    private fun initAdapter() {
        mAdapter = ForecastListAdapter(ArrayList(), this@ForecastsActivity, R.layout.item_forecast_list)
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM)
        mAdapter.setEnableLoadMore(true)
        mAdapter.setOnLoadMoreListener(this@ForecastsActivity, rlv_weixinjp)
        rlv_weixinjp.adapter = mAdapter
        mAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { _, _, position ->
            //startActivity<ForecastDetailActivity>("WEBVIEW_URL_KEY" to data[position].url)
            val inn = Intent(this@ForecastsActivity, ForecastDetailActivity::class.java)
            inn.putExtra("WEBVIEW_URL_KEY", mAdapter.getItem(position)?.url)
            startActivity(inn)
        }
    }

    override fun onLoadMoreRequested() {
        requestData(++pageNo, pageSize)
    }


    fun requestData(pno: Int, ps: Int) {
        mAdapter.loadMoreComplete()
        val forecastResult: ForecastResult = doAsyncResult {
            ForecastRequest(pno, ps).execute() }.get()
        mAdapter.setEnableLoadMore(pageNo < forecastResult.result.totalPage)
        if (pageNo == 1) {
            mAdapter.setNewData(forecastResult.result.list)
            rrl_weixinjp.setRefreshing(false)
        }else{
            mAdapter.addData(forecastResult.result.list)
        }
    }

    fun initActionBar(layoutId: Int) {
        val toolbar = find<Toolbar>(layoutId)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.menu_list -> {
                mAdapter.setLayout(R.layout.item_forecast_list)
                rlv_weixinjp.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            }
            R.id.menu_grid -> {
                mAdapter.setLayout(R.layout.item_forecast_grid)
                rlv_weixinjp.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.menu_stag -> {
                mAdapter.setLayout(R.layout.item_forecast_grid)
                rlv_weixinjp.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            }
        }
        rlv_weixinjp.adapter = mAdapter
        return true
    }
}
