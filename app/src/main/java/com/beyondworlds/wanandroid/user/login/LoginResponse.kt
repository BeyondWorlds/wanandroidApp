package com.beyondworlds.wanandroid.user.login

/**
 * Created by {wq} on 2018/6/27.
 */
data class LoginResponse(
        var errorCode: Int,
        var errorMsg: String?,
        var data: Data
) {
    data class Data(
            var id: Int,
            var username: String,
            var password: String,
            var email: String,
            var icon: String?,
            var type: Int,
            var collectIds: List<Int>?
    )
}