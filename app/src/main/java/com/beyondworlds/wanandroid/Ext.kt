package com.beyondworlds.wanandroid

import android.content.Context
import android.widget.Toast

/**
 * Created by {wq} on 2018/6/27.
 */
fun Context.toast(msg: String = "Default", duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this.applicationContext, msg, duration).show()
}