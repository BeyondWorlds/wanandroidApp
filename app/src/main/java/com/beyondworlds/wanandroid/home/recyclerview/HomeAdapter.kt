package com.beyondworlds.wanandroid.home.recyclerview

import android.content.Context
import com.beyondworlds.wanandroid.R
import com.beyondworlds.wanandroid.home.HomeInfo
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by {wq} on 2018/4/25.
 */
class HomeAdapter(val context: Context, var datas: ArrayList<HomeInfo.DataBean.DatasBean>?) : BaseQuickAdapter<HomeInfo.DataBean.DatasBean, BaseViewHolder>(R.layout.item_homelist, datas) {
    override fun convert(helper: BaseViewHolder, item: HomeInfo.DataBean.DatasBean?) {
        item ?: return
        helper.run {
            setText(R.id.tv_author, item.author)
            setText(R.id.tv_time, item.niceDate)
            setText(R.id.tv_title, item.title)
            setText(R.id.tv_category, item.chapterName)
            setImageResource(R.id.iv_like, if (item.isCollect) R.drawable.ic_like else R.drawable.ic_no_like)
        }
    }
}
