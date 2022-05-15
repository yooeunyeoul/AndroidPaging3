package com.dongeul.pagingsample.model
import java.io.Serializable


sealed class SampleModel(val type: FeedType) :Serializable {
    data class Data(
        val idx : Int,
        val existImage: Boolean=false,
        val content: String?=null,
        var likeCount: Int=0,
        var isLike: Boolean = false,
        var commentList: List<Comment>,
        val commentUser: String?=null
    ) : SampleModel(FeedType.DATA)

    data class Ad(val title: String) : SampleModel(FeedType.AD)
}

enum class FeedType {
    AD, DATA
}

data class Comment(val commentUser:String, val comment:String?)

