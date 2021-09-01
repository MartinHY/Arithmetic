package leetcode.动态规划


/**
 * 作者：MartinBZDQSM on 2021/9/1 14:12
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述 : 爬楼梯的问题
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 */
object Stair {

    @JvmStatic
    fun main(args: Array<String>) {
        println("最大值 ${solution2(10)} ")
    }

    /**
     * 迭代方法
     * 找到大概规律  , 自底向上思考 ,
     * 如果要4层的话是不是 要 5 次 1111 ,121,211,112,22
     * 得出大概结论 , f(n) = f(n-2)+f(n-1)
     */
    private fun solution(stairCount: Int): Int {
        if (stairCount <= 3)
            return stairCount
        return solution(stairCount - 2) + solution(stairCount - 1)
    }


    /**
     * 自底向上思考
     */
    private fun solution2(stairCount: Int): Int {
        if (stairCount <= 3)
            return stairCount
        val array = arrayOfNulls<Int>(stairCount + 1)
        array[0] = 1
        array[1] = 2
        for (i in 2..stairCount) {
            array[i] = array[i - 2]!! + array[i - 1]!!
        }
        return array[stairCount - 1] ?: 0
    }
}