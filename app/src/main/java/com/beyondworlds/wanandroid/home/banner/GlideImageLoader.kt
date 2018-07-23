package com.beyondworlds.wanandroid.home.banner

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.youth.banner.loader.ImageLoader

/**
 * Created by {wq} on 2018/4/21.
 */
class GlideImageLoader : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        // imageView?.scaleType = ImageView.ScaleType.FIT_XY
        Glide.with(context).load(path).into(imageView)
    }
}