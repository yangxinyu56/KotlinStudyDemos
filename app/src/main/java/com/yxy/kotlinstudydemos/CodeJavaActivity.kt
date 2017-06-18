package com.yxy.kotlinstudydemos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_code_java.*
import org.jetbrains.anko.toast

class CodeJavaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_java)
        tv_click.setOnClickListener {  }
        toast("")
    }
}
