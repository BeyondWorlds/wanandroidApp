package com.beyondworlds.wanandroid.user.login

import android.text.TextUtils
import android.view.View
import com.beyondworlds.wanandroid.Constant
import com.beyondworlds.wanandroid.R
import com.beyondworlds.wanandroid.app.Preference
import com.beyondworlds.wanandroid.base.BaseActivity
import com.beyondworlds.wanandroid.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginView {
    /**
     * check login for SharedPreferences
     */
    private var isLogin: Boolean by Preference(Constant.LOGIN_KEY, false)
    /**
     * local username
     */
    private var user: String by Preference(Constant.USERNAME_KEY, "")
    /**
     * local password
     */
    private var pwd: String by Preference(Constant.PASSWORD_KEY, "")

    val mLoginPresenter: LoginPresenter by lazy {
        LoginPresenter(this)
    }

    override fun loginSuccess(response: LoginResponse) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginFailed(msg: String?) {
        toast(msg ?: "login failed")
    }


    override fun setLayoutId(): Int = R.layout.activity_login

    override fun initView() {
        login_btn.setOnClickListener {
            if (checkContent()) {
                mLoginPresenter.loginWanAndroid(et_login_account.text.toString(), et_login_pwd.text.toString())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    /**
     * check username and password and password confirm field to login or register.
     * @return success return true, failed return false.
     */
    private fun checkContent(): Boolean {
        // error hint
        et_login_account.error = null
        et_login_pwd.error = null
        // cancel
        var cancel = false
        // attempt to view
        var focusView: View? = null
        // if register, check password confirm
        val pwdText = et_login_pwd.text.toString()
        val usernameText = et_login_account.text.toString()

        // check password
        if (TextUtils.isEmpty(pwdText)) {
            et_login_pwd.error = getString(R.string.password_not_empty)
            focusView = et_login_pwd
            cancel = true
        } else if (et_login_pwd.text.length < 6) {
            et_login_pwd.error = getString(R.string.password_length_short)
            focusView = et_login_pwd
            cancel = true
        }

        // check username
        if (TextUtils.isEmpty(usernameText)) {
            et_login_account.error = getString(R.string.username_not_empty)
            focusView = et_login_account
            cancel = true
        }

        // requestFocus
        if (cancel) {
            if (focusView != null) {
                focusView.requestFocus()
            }
            return false
        } else {
            return true
        }
    }
}
