package leetcode.广度优先查找

import java.util.*

/**
 * 作者：MartinBZDQSM on 2021/9/2 18:40
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述 :
 *  给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 *  给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 *  完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 */
object SquareNum {

    @JvmStatic
    fun main(args: Array<String>) {
        solusion(10)
    }

    /**
     * 广度优先查找
     */
    private fun solusion(num: Int) {
//        val queue = LinkedList<Int>()
//        val size = Math.sqrt(num.toDouble()).toInt()
//        val minQueueSize = Int.MAX_VALUE
//        for (i in size + 1 downTo  1) {
//            val addtion = i * i
//            queue.push(i)
//            while (queue.isNotEmpty()) {
//                if (addtion <)
//                    queue.push(addtion - 1)
//            }
//        }
    }


}