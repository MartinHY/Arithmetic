package leetcode.动态规划

import java.lang.Integer.min

/**
 * 作者：MartinBZDQSM on 2021/9/1 14:48
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述 :
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 *
 * 问总共有多少条不同的路径？
 *
 * 输入：m = 7, n = 3
 * 输出：28
 */
object gride {

    @JvmStatic
    fun main(args: Array<String>) {
        println("最大值 ${solution2Opitmazed(7,3)} ")
    }

    /**
     * 基本的思考 , 如果要到达 (m,n) ; 那么有且仅有可能两种路径 (m-1,n) 或者 (m,n-1) 两种路径
     * 那么基本可以得出 db(m,n) = (m-1,n)或者  (m,n-1)
     * 迭代的方式 : 到51 就会超时
     */
    private fun solution(m: Int, n: Int): Int {
        if (min(m, n) == 1) return 1
        return solution(m - 1, n ) + solution(m, n - 1)
    }

    /**
     * 动态规划的方式 :
     * 跟迭代法类似也是找规律
     */
    private fun solution2(m: Int, n: Int): Int {
        val arrays = Array(m){
            IntArray(n){1}
        }
        for (x in 1 until m) {
            for (y in 1 until n) {
                arrays[x][y] = arrays[x - 1][y] + arrays[x][y - 1]
            }
        }
        return arrays[m-1][n-1]
    }

    /**
     * 动态规划滚动数组的优化 :
     *  原理 , 因为此次的数据只需要依赖最多两行的历史数据
     *
     */
    private fun solution2Opitmazed(m: Int, n: Int): Int {
        val arrays = Array(2){
            IntArray(n){1}
        }
        for (x in 1 until m) {
            for (y in 1 until n) {
                arrays[x%2][y] = arrays[(x - 1)%2][y] + arrays[x%2][y - 1]
            }
        }
        return arrays[(m-1)%2][n-1]//由于缓存数据中 , x 是从1 开始的 , 也就是对应的m需要减1算余数才能得出结果
    }


    /**
     * 公式 :
     * 线性代数 组合
     * https://zhuanlan.zhihu.com/p/41855459
     * 从起点到终点的步数最多也就 m+n-2 , 也就是说 (m+n-2)往下走的最多种可能
     */
    private fun solution3(m: Int, n: Int): Int {
        val arrays = Array(m){
            IntArray(n){1}
        }
        for (x in 1 until m) {
            for (y in 1 until n) {
                arrays[x][y] = arrays[x - 1][y] + arrays[x][y - 1]
            }
        }
        return arrays[m-1][n-1]
    }
}