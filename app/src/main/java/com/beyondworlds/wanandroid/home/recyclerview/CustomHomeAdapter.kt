package com.beyondworlds.wanandroid.home.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.beyondworlds.wanandroid.R
import com.beyondworlds.wanandroid.home.HomeInfo

/**
 * Created by {wq} on 2018/4/25.
 */
class CustomHomeAdapter(val context: Context, var datas: ArrayList<HomeInfo.DataBean.DatasBean>?) : RecyclerView.Adapter<CustomHomeAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_homelist, parent, false))
    }

    override fun getItemCount(): Int {
        return datas?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item = datas?.get(position)
        item ?: return
        holder.tv_author.text = item.author
        holder.tv_time.text = item.niceDate
        holder.tv_title.text = item.title
        holder.tv_category.text = item.chapterName
        holder.iv_like.setImageResource(if (item.isCollect) R.drawable.ic_like else R.drawable.ic_no_like)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_author: TextView
        var tv_time: TextView
        var tv_title: TextView
        var tv_category: TextView
        var iv_like: ImageView

        init {
            tv_author = itemView.findViewById(R.id.tv_author)
            tv_time = itemView.findViewById(R.id.tv_time)
            tv_title = itemView.findViewById(R.id.tv_title)
            tv_category = itemView.findViewById(R.id.tv_category)
            iv_like = itemView.findViewById(R.id.iv_like)
        }
    }
}
