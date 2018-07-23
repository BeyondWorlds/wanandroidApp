package com.beyondworlds.wanandroid.home

import com.beyondworlds.wanandroid.home.banner.BannerInfo

/**
 * Created by {wq} on 2018/4/25.
 */
interface HomeFragmentView {
    fun getHomeListSuccess(homeInfo:HomeInfo?)

    fun getHomeListFailed(errMsg: String)

    fun getBannerSuccess(bannerInfo: BannerInfo?)

    fun getBannerFailed(errMsg: String)
}