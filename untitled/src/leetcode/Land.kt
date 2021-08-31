package leetcode

import kotlin.math.abs

/**
 * 作者：MartinBZDQSM on 2021/8/31 16:16
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述 : 岛屿问题
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 *示例 1:
 *输入:
 * 1 1 1 1 0
 * 1 1 0 1 0
 * 1 1 0 0 0
 * 0 0 0 0 0
 *输出: 1
 *
 *示例 2:
 *输入:
 * 1 1 0 0 0
 * 1 1 0 0 0
 * 0 0 1 0 0
 * 0 0 0 1 1
 *输出: 3
 *
 *
 *
 */
object Land {

    @JvmStatic
    fun main(args: Array<String>) {
        val arrays = Array(4) { x ->
            when (x) {
                0 -> {
                    arrayOf(1, 1, 1, 1, 0)
                }
                1 -> {
                    arrayOf(1, 1, 0, 0, 0)
                }
                2 -> {
                    arrayOf(0, 0, 1, 0, 0)
                }
                3 -> {
                    arrayOf(0, 0, 0, 1, 1)
                }
                else -> arrayOf(Int.MAX_VALUE, -1, 0, Int.MAX_VALUE)
            }
        }
        println("岛屿数量 ${solution(arrays)} ")
        for (i in arrays.indices) {
            for (j in 0 until arrays[0].size) {
                print(arrays[i][j].toString() + " | ")
            }
            println()
        }
    }

    /**
     * 基本分析,  与门的解决方案大概是一致的 , 只不过部分处理是不一样的
     *
     */
    private fun solution(arrays: Array<Array<Int>>): Int {
        var tag = 0
        arrays.forEachIndexed { x, ints ->
            ints.forEachIndexed { y, i ->
                if (i == 1){
                    tag--
                    findLand(arrays,x,y,tag)
                }
            }
        }
        return abs(tag)
    }

    private fun findLand(arrays: Array<Array<Int>>, x: Int, y: Int, tag: Int) {
        if (x < 0 || y < 0 || x >= arrays.size || y >= arrays[0].size || arrays[x][y] == tag || arrays[x][y] == 0) {
            return
        }
        arrays[x][y] = tag
        findLand(arrays, x, y - 1, tag)
        findLand(arrays, x - 1, y, tag)
        findLand(arrays, x + 1, y, tag)
        findLand(arrays, x, y + 1, tag)
    }
}