package structure

import java.util.*

/**
 * 作者：MartinBZDQSM on 2021/10/23
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述 :
 */
object 旋转输出矩阵 {

    @JvmStatic
    fun main(args: Array<String>) {
        val matrix = Array<IntArray>(4){
            when(it){
                0->
                    intArrayOf(1,2,3,4)
                1->
                   intArrayOf(5,6,7,8)
                2->
                    intArrayOf(9,10,11,12)
                3->
                    intArrayOf(13,14,15,16)
                else->
                    intArrayOf(1,2,3,4)
            }
        }

        println("旋转输出矩阵 : ${spiralOrder(matrix).contentToString()}")
    }

    /**
     *   执行用时：220 ms, 在所有 Kotlin 提交中击败了89.47%的用户内存消耗：36.8 MB, 在所有 Kotlin 提交中击败了100.00%的用户
     */
    private fun spiralOrder(matrix: Array<IntArray>): IntArray {
        if (matrix.isEmpty()) {
            return IntArray(0)
        }
        var ySize = matrix.size
        var xSize = matrix[0].size
        val allSize = ySize*xSize
        val result = IntArray(allSize)
        var cx = 0
        var cy = 0
        var index = 0
        while (index < result.size){
            for(x in cx until xSize){
                if (index == result.size) return result
                result[index] = matrix[cy][x]
                index++
            }
            cy++
            for(y in cy until ySize){
                if (index == result.size) return result
                result[index] = matrix[y][xSize-1]
                index++
            }
            ySize-=1
            xSize-=1
            for(x in xSize-1 downTo cx){
                if (index == result.size) return result
                result[index] = matrix[ySize][x]
                index++
            }
            for(y in ySize-1 downTo cy){
                if (index == result.size) return result
                result[index] = matrix[y][cx]
                index++
            }
            cx++
        }
        return result
    }
}