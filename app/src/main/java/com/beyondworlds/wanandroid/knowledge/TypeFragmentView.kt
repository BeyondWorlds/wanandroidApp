package com.beyondworlds.wanandroid.knowledge

/**
 * Created by {wq} on 2018/5/3.
 */
interface TypeFragmentView {

    fun getTreeListSuccess(data: List<KnowledgeInfo.DataBean>?)

    fun getTreeListFailed(err: String)
}