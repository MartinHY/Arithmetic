package leetcode.动态规划

import kotlin.math.max

/**
 * 作者：MartinBZDQSM on 2021/9/1 12:42
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述 :
 *  在上面的数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。路径上的每一步都只能往左下或 右下走。只需要求出这个最大和即可，不必给出具体路径。
 *  三角形的行数大于1小于等于100，数字为 0 - 99
 *
 *  输入格式：
 *
 *  5      //表示三角形的行数    接下来输入三角形
 *
 *  7
 *  3   8
 *  8   1   0
 *  2   7   4   4
 *  4   5   2   6   5
 *要求输出最大和
 */
object TrangleBigNum {

    @JvmStatic
    fun main(args: Array<String>) {
        val arrays = Array(5) { x ->
            when (x) {
                0 -> {
                    arrayOf(7)
                }
                1 -> {
                    arrayOf(3, 8)
                }
                2 -> {
                    arrayOf(8, 1, 8)
                }
                3 -> {
                    arrayOf(2, 7, 4, 4)
                }
                4 -> {
                    arrayOf(4, 5, 2, 6, 5)
                }
                else -> arrayOf(Int.MAX_VALUE, -1, 0, Int.MAX_VALUE)
            }
        }
        println("最大值 ${solution(arrays,arrays.size)} ")
    }

    /**
     * 动态规划 存储 ,  找到每一步的最优解,其他的舍弃
     */
    private fun solution(arrays: Array<Array<Int>>, rowSize: Int): Int {
        //需要从倒数第二列开始查找
        for (row in rowSize - 2 downTo 0) {
            for (clum in 0..row) {
                arrays[row][clum] += max(arrays[row + 1][clum], arrays[row + 1][clum + 1])
            }
        }
        return arrays[0][0]
    }

    /**
     * 迭代
     */
    private fun solution2(arrays: Array<Array<Int>>, rowSize: Int): Int {
        //需要从倒数第二列开始查找

        return arrays[0][0]
    }

}