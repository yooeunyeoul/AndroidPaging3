package com.dongeul.pagingsample.network

import com.dongeul.pagingsample.model.Comment
import com.dongeul.pagingsample.model.SampleModel
import com.dongeul.pagingsample.model.PagingSample
import javax.inject.Inject

class SampleBackendService @Inject constructor() {

    fun getPagingData(page: Int): PagingSample {
        val result = mutableListOf<SampleModel>()

        val start = page * 10
        for (i in start until start + 10) {
            when {
                i != 0 && i % 3 == 0 -> {
                    result.add(SampleModel.Ad(title = "구글광고"))
                }

                i % 2 == 0 -> {
                    result.add(
                        SampleModel.Data(
                            idx = i,
                            existImage = true,
                            content = "$i 번째 해당 콘텐트는 이미자가 있는 뷰 입니다. ",
                            likeCount = 0,
                            commentUser = "$i 번째 아무개",
                            commentList = listOf(
                                Comment(
                                    commentUser = "$i 번째 아무개 유저",
                                    comment = "안녕하세요. 요즘 돌아다니기 좋은 날씨네요."
                                ),
                                Comment(
                                    commentUser = "${i + 1} 번째 아무개 유저",
                                    comment = "화창한 날씨 너무 좋아요."
                                )
                            )
                        )
                    )
                }
                else -> {
                    result.add(
                        SampleModel.Data(
                            idx = i,
                            existImage = false,
                            content = "$i 번째 해당 콘텐트는 이미지가 없는 뷰 입니다. ",
                            likeCount = 0,
                            commentUser = "$i 번째 아무개",
                            commentList = listOf(
                                Comment(
                                    commentUser = "$i 번째 아무개 유저",
                                    comment = "안녕하세요. 요즘 돌아다니기 좋은 날씨네요."
                                ),
                                Comment(
                                    commentUser = "${i + 1} 번째 아무개 유저",
                                    comment = "화창한 날씨 너무 좋아요."
                                )
                            )
                        )
                    )
                }
            }

        }
        return PagingSample(
            data = result,
            page = page + 1
        )
    }

    fun getChartData(count: Int): List<Float> {
        val list = mutableListOf<Float>()
        for (i in 0..count) {
            val floatVal: Float = ((Math.random())).toFloat()
            list.add(floatVal)
        }
        return list
    }
}