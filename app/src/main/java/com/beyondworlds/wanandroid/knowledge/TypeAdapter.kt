package com.beyondworlds.wanandroid.knowledge

import android.content.Context
import com.beyondworlds.wanandroid.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by {wq} on 2018/5/3.
 */
class TypeAdapter(val context: Context, datas: List<KnowledgeInfo.DataBean>) : BaseQuickAdapter<KnowledgeInfo.DataBean, BaseViewHolder>(R.layout.item_knowledgelist, datas) {
    override fun convert(helper: BaseViewHolder, item: KnowledgeInfo.DataBean?) {
        item ?: return
        helper.setText(R.id.tv_firstName, item.name)
        item.children?.let { children ->
            helper.setText(R.id.tv_secondName, children.joinToString("    ",
                    transform = { childrenBean -> childrenBean.name }))
        }

    }
}