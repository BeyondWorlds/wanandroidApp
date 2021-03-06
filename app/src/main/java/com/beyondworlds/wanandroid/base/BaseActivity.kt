package com.beyondworlds.wanandroid.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        initView()
    }

    protected abstract fun setLayoutId(): Int
    protected abstract fun initView()
}
