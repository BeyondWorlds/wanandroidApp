package com.beyondworlds.wanandroid.home.banner

/**
 * Created by {wq} on 2018/4/23.
 */

class BannerInfo(var errorCode: Int = 0,
                 var errorMsg: String = "",
                 var data: List<DataBean>? = null) {
    class DataBean {
        /**
         * desc : 一起来做个App吧
         * id : 10
         * imagePath : http://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png
         * isVisible : 1
         * order : 0
         * title : 一起来做个App吧
         * type : 0
         * url : http://www.wanandroid.com/blog/show/2
         */

        var desc: String? = null
        var id: Int = 0
        var imagePath: String = ""
        var isVisible: Int = 0
        var order: Int = 0
        var title: String? = null
        var type: Int = 0
        var url: String? = null
    }
}
