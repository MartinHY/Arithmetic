package leetcode

import java.lang.Integer.min
import java.util.*
import kotlin.collections.HashSet


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
                    arrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE, -1)
                }
                2 -> {
                    arrayOf(Int.MAX_VALUE, -1, Int.MAX_VALUE, -1)
                }
                3 -> {
                    arrayOf(0, -1, Int.MAX_VALUE, Int.MAX_VALUE)
                }
                else -> arrayOf(Int.MAX_VALUE, -1, 0, Int.MAX_VALUE)
            }
        }
        solution2(arrays)
        for (i in arrays.indices) {
            for (j in 0 until arrays[0].size) {
                print(arrays[i][j].toString() + " | ")
            }
            println()
        }
    }

    /**
     * INF 用 1 来代替
     * 利用 广度优先搜索 来查找最小路径
     */
    private fun solution(arrays: Array<Array<Int>>) {
        if (arrays.isEmpty()) return
        //先查找到对应门的数量
        val maxX = arrays.size
        val maxY = arrays.first().size
        arrays.forEachIndexed { x, ints ->
            ints.forEachIndexed { y, i ->
                if (i == 0) {
                    val queue = LinkedList<Array<Int>>()
                    val set = HashSet<String>()//防止重复
                    queue.push(arrayOf(x, y))
                    set.add("$x$y")
                    var layer = 1
                    while (queue.isNotEmpty()) {
                        val size = queue.size
                        for (i in 0 until size) {
                            val target = queue.pop()
                            val x1 = target[0]
                            val y1 = target[1]

                            val left = x1 - 1
                            val right = x1 + 1
                            val top = y1 - 1
                            val bottom = y1 + 1
                            if (top >= 0 && arrays[x1][top] > 0 && !set.contains("$x1$top")) {
                                queue.add(arrayOf(x1, top))
                                set.add("$x1$top")
                                arrays[x1][top] = min(arrays[x1][top], layer)
                            }
                            if (left >= 0 && arrays[left][y1] > 0 && !set.contains("$left$y1")) {
                                queue.add(arrayOf(left, y1))
                                set.add("$left$y1")
                                arrays[left][y1] = min(arrays[left][y1], layer)
                            }

                            if (right < maxX && arrays[right][y1] > 0 && !set.contains("$right$y1")) {
                                queue.add(arrayOf(right, y1))
                                set.add("$right$y1")
                                arrays[right][y1] = min(arrays[right][y1], layer)
                            }

                            if (bottom < maxY && arrays[x1][bottom] > 0 && !set.contains("$x1$bottom")) {
                                queue.add(arrayOf(x1, bottom))
                                set.add("$x1$bottom")
                                arrays[x1][bottom] = min(arrays[x1][bottom], layer)
                            }
                        }
                        layer++
                    }
                }
            }
        }
    }


    /**
     * INF 用 1 来代替
     * 利用迭代思想
     */
    private fun solution2(arrays: Array<Array<Int>>) {
        if (arrays.isEmpty()) return
        arrays.forEachIndexed { x, ints ->
            ints.forEachIndexed { y, i ->
                if (i == 0) {//为门时
                    val set = HashSet<String>()//防止重复
                    finding(arrays, set, x, y, 0)
                }
            }
        }
    }

    private fun finding(arrays: Array<Array<Int>>, set: HashSet<String>, x: Int, y: Int, count: Int) {
        if (x < 0 || y < 0 || x >= arrays.size || y >= arrays[0].size || arrays[x][y] < count) {
            return
        }
        arrays[x][y] = min(arrays[x][y], count)
        finding(arrays, set, x, y - 1, count + 1)
        finding(arrays, set, x - 1, y, count + 1)
        finding(arrays, set, x + 1, y, count + 1)
        finding(arrays, set, x, y + 1, count + 1)
    }
}