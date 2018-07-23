package com.beyondworlds.wanandroid.knowledge

/**
 * Created by {wq} on 2018/5/3.
 */

class KnowledgeInfo {
    var errorCode: Int = 0
    var errorMsg: String? = null
    var data: List<DataBean>? = null

    class DataBean {

        var courseId: Int = 0
        var id: Int = 0
        var name: String? = null
        var order: Int = 0
        var parentChapterId: Int = 0
        var visible: Int = 0
        var children: List<ChildrenBean>? = null

        class ChildrenBean(var courseId: Int,
                           var id: Int,
                           var name: String,
                           var order: Int,
                           var parentChapterId: Int,
                           var visible: Int,
                           var children: List<*>? = null)
    }
}
