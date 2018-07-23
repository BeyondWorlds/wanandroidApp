package com.beyondworlds.wanandroid.home

import com.beyondworlds.wanandroid.base.BasePresenter
import com.beyondworlds.wanandroid.home.banner.BannerInfo
import com.beyondworlds.wanandroid.http.HttpHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by {wq} on 2018/4/25.
 */
class HomeFragmentPresenter(var homeFragmentView: HomeFragmentView?) : BasePresenter {
    /**
     * release
     */
    override fun release() {
        homeFragmentView = null
    }

    fun getBanner() {
        HttpHelper.retrofitService
                .getBanner()
                .enqueue(object : Callback<BannerInfo> {
                    override fun onFailure(call: Call<BannerInfo>?, t: Throwable?) {
                        homeFragmentView?.getBannerFailed(t?.message.toString())
                    }

                    override fun onResponse(call: Call<BannerInfo>?, response: Response<BannerInfo>?) {
                        homeFragmentView?.getBannerSuccess(response?.body())
                    }

                })
    }

    fun getHomeList(index: Int = 0) {
        HttpHelper.retrofitService
                .getHomeList(index)
                .enqueue(object : Callback<HomeInfo> {
                    override fun onResponse(call: Call<HomeInfo>?, response: Response<HomeInfo>?) {
                        homeFragmentView?.getHomeListSuccess(response?.body())
                    }

                    override fun onFailure(call: Call<HomeInfo>?, t: Throwable?) {
                        homeFragmentView?.getHomeListFailed(t?.message.toString())
                    }
                })
    }
}