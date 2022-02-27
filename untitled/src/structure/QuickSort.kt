package structure

import leetcode.动态规划.Stair
import java.util.*

/**
 * 作者：MartinBZDQSM on 2022/2/20
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述 :
 */
object QuickSort {

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = arrayOf(4, 5,11,225,221,336,59, 2, 8,20,10,6, 5)
        println("快速排序結果  ${quickSort(arr, 0, arr.size - 1).contentToString()} ")
    }

    private fun quickSort(arr: Array<Int>, left: Int, right: Int): Array<Int> {
        if (left < right) {
            val partitionIndex = partition(arr, left, right)
            quickSort(arr, left, partitionIndex - 1)
            quickSort(arr, partitionIndex + 1, right)
        }
        return arr
    }

    private fun partition(arr: Array<Int>, left: Int, right: Int): Int {
        // 设定基准值（pivot）
        var index = left + 1
        for (i in index..right) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index)
                index++
            }
        }
        swap(arr, left, index - 1)
        return index - 1
    }

    private fun swap(arr: Array<Int>, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}