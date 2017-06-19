package com.yxy.kotlinstudydemos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import org.jetbrains.anko.find

class ForecastDetailActivity : AppCompatActivity() {

    var urlString: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast_detail)
        val mWebView = find<WebView>(R.id.wv_wxjp_detail)
        val bundle = intent.extras
        urlString = bundle.getString("WEBVIEW_URL_KEY")
        mWebView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                return shouldOverrideUrlLoading(view, request)
            }
        })
        mWebView.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
                // 返回键退回
                mWebView.goBack()
                true
            } else
                false
        }
        mWebView.loadUrl(urlString)
    }
}
