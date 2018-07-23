package com.beyondworlds.wanandroid.home

/**
 * Created by {wq} on 2018/4/25.
 */

class HomeInfo(var data: DataBean,
               var errorCode: Int = 0,
               var errorMsg: String) {
    class DataBean {
        var curPage: Int = 0
        var offset: Int = 0
        var isOver: Boolean = false
        var pageCount: Int = 0
        var size: Int = 0
        var total: Int = 0
        var datas: ArrayList<DatasBean>? = null

        class DatasBean {
            var apkLink: String? = null
            var author: String? = null
            var chapterId: Int = 0
            var chapterName: String? = null
            var isCollect: Boolean = false
            var courseId: Int = 0
            var desc: String? = null
            var envelopePic: String? = null
            var isFresh: Boolean = false
            var id: Int = 0
            var link: String? = null
            var niceDate: String? = null
            var origin: String? = null
            var projectLink: String? = null
            var publishTime: Long = 0
            var superChapterId: Int = 0
            var superChapterName: String? = null
            var title: String? = null
            var type: Int = 0
            var visible: Int = 0
            var zan: Int = 0
            var tags: List<*>? = null
        }
    }
}
