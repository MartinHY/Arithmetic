package leetcode


/**
 * 作者：MartinBZDQSM on 星期一
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 * 题目来源 : [队列和广度优先搜索]墙与门
 *
 *
 *    你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：
 *    -1 表示墙或是障碍物
 *    0 表示一扇门
 *    INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
 *    你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
 *
 *    示例：
 *
 *    给定二维网格：
 *
 *    INF  -1  0  INF
 *    INF INF INF  -1
 *    INF  -1 INF  -1
 *    0  -1 INF INF
 *    运行完你的函数后，该网格应该变成：
 *
 *    3  -1   0   1
 *    2   2   1  -1
 *    1  -1   2  -1
 *    0  -1   3   4
 *
 */


object DoorAndBlock {

    @JvmStatic
    fun main(args: Array<String>) {
        val arrays = Array(4) { x ->
            when (x) {
                0 -> {
                    arrayOf(Int.MAX_VALUE, -1, 0, Int.MAX_VALUE)
                }
                1 -> {
                    arrayOf(2, 2, 1, -1)
                }
                2 -> {
                    arrayOf(1, -1, 2, -1)
                }
                3 -> {
                    arrayOf(0, -1, 3, 4)
                }
                else -> arrayOf(Int.MAX_VALUE, -1, 0, Int.MAX_VALUE)
            }
        }
        solution(arrays)
    }

    /**
     * INF 用 1 来代替
     * 利用 广度优先搜索 来查找最小路径
     */
    fun solution(arrays: Array<Array<Int>>) {
        if (arrays.isEmpty()) return
        //先查找到对应门的数量
        val positions = mutableListOf<Position>()
        arrays.forEachIndexed { x, ints ->
            ints.forEachIndexed { y, i ->
                if (i == 0) {
                    positions.add(Position(x, y))
                }
            }
        }
        val maxX = arrays.size
        val maxY = arrays.first().size
        positions.forEach {
            //  x- x+ y- y+ 一共四个方向的位移


        }
    }

    /**
     * 用于位置标记
     */
    internal class Position(val x: Int, val y: Int)

}