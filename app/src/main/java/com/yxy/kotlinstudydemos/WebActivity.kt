package com.yxy.kotlinstudydemos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.yxy.kotlinstudydemos.databinding.ActivityWebBinding
import com.yxy.kotlinstudydemos.databinding.BindingActivity
import com.yxy.kotlinstudydemos.databinding.viewmodel.WebInfoViewModel

open class WebActivity : BindingActivity<WebInfoViewModel, ActivityWebBinding>() {

    override fun setupLayoutId() = R.layout.activity_web
    override fun setupViewModel() = WebInfoViewModel()
    override fun setupViewModelId() =  BR.viewModel

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView(binding: ActivityWebBinding) {
        binding.wvInfo.settings.javaScriptEnabled = true
        with(binding.wvInfo) {
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
            setOnKeyListener { _, keyCode, _ ->
                if (keyCode == KeyEvent.KEYCODE_BACK && canGoBack()) {
                    // 返回键退回
                    goBack()
                    true
                } else
                    false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras[C.intent.web_info]?.let {
            mBinding.wvInfo.loadUrl(it.toString())
        }
    }
}
