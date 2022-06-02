package com.dongeul.pagingsample.model
import java.io.Serializable


sealed class SampleModel() :Serializable {
    data class Data(
        val idx : Int,
        val existImage: Boolean=false,
        val content: String?=null,
        var likeCount: Int=0,
        var isLike: Boolean = false,
        var commentList: List<Comment>,
        val commentUser: String?=null
    ):SampleModel()

    data class Ad(val title: String):SampleModel()
}

data class Comment(val commentUser:String, val comment:String?)

