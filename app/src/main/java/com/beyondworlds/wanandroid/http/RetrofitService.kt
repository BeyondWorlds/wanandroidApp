package com.beyondworlds.wanandroid.http

import com.beyondworlds.wanandroid.home.HomeInfo
import com.beyondworlds.wanandroid.home.banner.BannerInfo
import com.beyondworlds.wanandroid.knowledge.KnowledgeInfo
import com.beyondworlds.wanandroid.user.login.LoginResponse
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by {wq} on 2018/4/21.
 */
interface RetrofitService {
    @GET("/banner/json")
    fun getBanner(): Call<BannerInfo>

    @GET("/article/list/{page}/json")
    fun getHomeList(@Path("page") page: Int): Call<HomeInfo>

    @GET("/tree/json")
    fun getTreeList(): Call<KnowledgeInfo>

    /**
     * 登录
     * @param username username
     * @param password password
     * @return Deferred<LoginResponse>
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun loginWanAndroid(
            @Field("username") username: String,
            @Field("password") password: String
    ): LoginResponse
}