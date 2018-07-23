package com.beyondworlds.wanandroid.http

import com.beyondworlds.wanandroid.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by {wq} on 2018/4/21.
 */
object HttpHelper {
    val retrofitService: RetrofitService = HttpHelper.getService()

    private fun getService(): RetrofitService {
        var retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(RetrofitService::class.java)
    }
}