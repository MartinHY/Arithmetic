package structure

import java.util.*

/**
 * 作者：MartinBZDQSM on 2021/9/22 17:15
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 * 题目描述 : 如何在一个1到100的整数数组中找到丢失的数字
 * BitSet 的使用
 */
@Suppress("ClassName")
object `如何在一个1到100的整数数组中找到丢失的数字？` {

    @JvmStatic
    fun main(args: Array<String>) {
        println("丢失数量 : ${findLossSize(arrayOf(1,3,4,5,6,7,8,9),10)}")
    }

    private fun findLossSize(array: Array<Int>, count: Int):Int {
        val bitSet = BitSet(array.size)
        array.forEach { bitSet.set(it) }
        var num = 0
        for( i in 1 .. count){
            if (!bitSet.get(i)){
                println("丢失的值 : $i")
                num++
            }
        }
        return num
    }

}