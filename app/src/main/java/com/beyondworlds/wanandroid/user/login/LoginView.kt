package com.beyondworlds.wanandroid.user.login

import com.beyondworlds.wanandroid.base.BaseView

/**
 * Created by {wq} on 2018/6/27.
 */
interface LoginView :BaseView{

    fun loginSuccess(response: LoginResponse)

    fun loginFailed(msg: String?)
}