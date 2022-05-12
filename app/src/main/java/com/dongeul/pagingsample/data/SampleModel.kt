package com.dongeul.pagingsample.data


sealed class SampleModel(val type: FeedType) {
    data class Data(
        val idx : Int,
        val existImage: Boolean=false,
        val content: String?=null,
        val likeCount: Int?=null,
        var isLike: Boolean = false,
        val commentList: List<Comment>,
        val commentUser: String?=null
    ) : SampleModel(FeedType.DATA)

    data class Ad(val title: String) : SampleModel(FeedType.AD)
}

enum class FeedType {
    AD, DATA
}

data class Comment(val commentUser:String, val comment:String?)

