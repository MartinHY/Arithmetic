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
        println("最少数量 ${solution2(12 )} ")

    }

    /**
     * 广度优先遍历.主要还是步骤分层思考
     */
    private fun solusion(n: Int):Int {
        val queue: Queue<Int> = LinkedList<Int>()
        val set = HashSet<Int>()
        queue.offer(0)
        set.add(0)
        var level = 0
        while (queue.isNotEmpty()){
                level++
            val size = queue.size
            for (i in 0 until size){
                //逐层计算 ,
                val digit = queue.poll()
                for(j in 1 until n){
                    val value = digit + j*j
                    if (value == n) return level
                    if (value>n)break
                    //如果当前节点(已经算过的和) 先添加是不是level 就是最低的!!!
                    //如果不是添加到下一轮节点当中去
                    if (!set.contains(value)){
                        queue.offer(value)
                        set.add(value)
                    }
                }
            }
        }
        return level
    }

    /**
     * 动态规划
     * 60  = dp(11) + 1 (1 是 7*7)
     * 11 = 60-7*7
     */
    private fun solution2(n:Int):Int{
        val dp = arrayOfNulls<Int>(n+1)
        dp[0] = 0
        for (i in 1..n) {
            dp[i] = i //最坏的情况都是由1的平方组成
            var j = 1
            while (j * j <= i) {
                //动态规划公式
                dp[i] = Math.min(dp[i]!!, dp[i - j * j]!! + 1)
                j++
            }
        }
        return dp[n]?:0
    }
}