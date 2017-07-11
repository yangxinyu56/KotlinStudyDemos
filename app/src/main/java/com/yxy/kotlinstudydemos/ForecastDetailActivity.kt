package com.yxy.kotlinstudydemos

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_forecast_detail.*

class ForecastDetailActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast_detail)

        wv_wxjp_detail.settings.javaScriptEnabled = true
        with(wv_wxjp_detail) {
            setWebChromeClient(WebChromeClient())
            setWebViewClient(WebViewClient())
            setOnKeyListener { _, keyCode, _ ->
                if (keyCode == KeyEvent.KEYCODE_BACK && wv_wxjp_detail.canGoBack()) {
                    // 返回键退回
                    wv_wxjp_detail.goBack()
                    true
                } else
                    false
            }
        }
        intent.extras["WEBVIEW_URL_KEY"]?.let {
            wv_wxjp_detail.loadUrl(it.toString())
        }
    }
}
