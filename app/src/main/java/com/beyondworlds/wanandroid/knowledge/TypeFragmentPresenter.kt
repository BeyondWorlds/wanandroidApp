package com.beyondworlds.wanandroid.knowledge

import com.beyondworlds.wanandroid.http.HttpHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by {wq} on 2018/5/3.
 */
class TypeFragmentPresenter(val mTypeFragmentView: TypeFragmentView) {
    fun getTreeList() {
        HttpHelper.retrofitService
                .getTreeList()
                .enqueue(object : Callback<KnowledgeInfo> {
                    override fun onFailure(call: Call<KnowledgeInfo>?, t: Throwable) {
                        mTypeFragmentView.getTreeListFailed(t.message.toString())
                    }

                    override fun onResponse(call: Call<KnowledgeInfo>?, response: Response<KnowledgeInfo>?) {
                        mTypeFragmentView.getTreeListSuccess(response?.body()?.data)
                    }

                })
    }
}