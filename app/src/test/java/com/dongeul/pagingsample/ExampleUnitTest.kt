package com.dongeul.pagingsample

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `퍼센티지 구해보자`(){
        for (i in 0..10) {


            var d = Math.random() *100

            //50 % 33%
            //
            //20%

            // 1, 2 ,3

            // 6/1/  6/2 , 6/3
            when {
                d < 50 -> {
                    //50%
                    println("50프로 나오나 ")
                }

                d < 80 -> {
                    // 30 %
                    println("30프로 나오나 ")
                }
                else -> {
                    //17%
                    println("20프로 나오나 ")
                }
            }
        }

    }


}

