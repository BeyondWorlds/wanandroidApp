package com.beyondworlds.wanandroid.user.login

import com.beyondworlds.wanandroid.base.BasePresenter
import com.beyondworlds.wanandroid.http.HttpHelper
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

/**
 * Created by {wq} on 2018/6/27.
 */
class LoginPresenter(var loginView: LoginView?) : BasePresenter {
    var loginAsync: Deferred<LoginResponse>? = null

    override fun release() {
        loginAsync?.cancel()
        loginView = null
    }


    fun loginWanAndroid(username: String, password: String) {
        try {
            launch(UI) {
                loginAsync = async(CommonPool) { HttpHelper.retrofitService.loginWanAndroid(username, password) }
                val result = loginAsync?.await()
                if (result?.errorCode != 0) {
                    loginView?.loginFailed(result?.errorMsg)
                    return@launch
                }
                loginView?.loginSuccess(result)
            }
        } catch (e: Exception) {
            loginView?.loginFailed(e.message)
        }
    }
}