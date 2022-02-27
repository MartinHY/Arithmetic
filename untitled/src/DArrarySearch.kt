import kotlin.jvm.JvmStatic

/**
 * 作者：MartinBZDQSM on 2016/9/12 0012.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述(来源 剑指Offer)：
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，
 * 输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */

object DArrarySearch {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = arrayOf(intArrayOf(1, 5, 9), intArrayOf(2, 6, 10), intArrayOf(3, 7, 11), intArrayOf(4, 8, 12))
        for (i in array.indices) {
            for (j in 0 until array[0].size) {
                print(array[i][j].toString() + " | ")
            }
            println()
        }
        print("Result find1 :" + find1(array, 5))
        print("Result find2 :" + find2(array, 14))
        print("Result find3 :" + find3(array, 2))
    }

    //迭代 ，时间复杂度
    fun find1(array: Array<IntArray>, target: Int): Boolean {
        val x = array.size
        val y: Int = array[0].size
        for (i in 0 until x) {
            for (j in 0 until y) {
                if (array[i][j] == target) return true
            }
        }
        return false
    }

    //每一行开始二分查找
    fun find2(array: Array<IntArray>, target: Int): Boolean {
        val row = array.size
        val col: Int = array[0].size
        for (x in 0 until row) {
            var sign = (col - 1) / 2
            while (sign in 1 until col) if (array[x][sign] > target) {
                sign--
            } else if (array[x][sign] < target) {
                sign++
            } else {
                return true
            }
        }
        return false
    }

    //从右上角开始查找
    fun find3(array: Array<IntArray>, target: Int): Boolean {
        val row = array.size
        val col: Int = array[0].size
        var x = 0
        var y = col - 1
        while (x < row && y >= 0) {
            if (array[x][y] > target) {
                y--
            } else if (array[x][y] < target) {
                x++
            } else {
                return true
            }
        }
        return false
    }
}