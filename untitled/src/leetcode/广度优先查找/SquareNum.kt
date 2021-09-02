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
        println("最少数量 ${numSquares(10)} ")

    }

    /**
     * 广度优先查找 //todo 感觉有问题 哎
     */
    private fun solusion(n: Int):Int {

        val size = Math.sqrt(n.toDouble()).toInt()
        var minQueueSize = 0
        var result = 0
        for (i in size + 1 downTo  1) {
            var addtion = 0
            val queue = LinkedList<Int>()
            queue.push(i)
            minQueueSize = 0
            while (!queue.isEmpty()) {
                val value = queue.pop()
                val temp = value * value
                if (addtion + temp >n){
                    queue.push(value - 1)
                }else{
                    minQueueSize++
                    addtion += temp
                    queue.push(value)
                }
            }
            result = if (result == 0) minQueueSize
            else{
                if(minQueueSize>result){
                    return result
                }
                Math.min(result,minQueueSize)
            }
        }
        return result
    }
    fun numSquares(n: Int): Int {
        val queue: Queue<Int> = LinkedList<Int>()
        //记录访问过的节点值
        val visited: MutableSet<Int> = HashSet()
        queue.offer(0)
        visited.add(0)
        //树的第几层
        var level = 0
        while (!queue.isEmpty()) {
            //每一层的节点数量
            val size: Int = queue.size
            level++
            //遍历当前层的所有节点
            for (i in 0 until size) {
                //节点的值
                val digit = queue.poll()
                //访问当前节点的子节点，类比于二叉树的左右子节点
                for (j in 1..n) {
                    //子节点的值
                    val nodeValue = digit + j * j
                    //nodeValue始终是完全平方数的和，当他等于n的
                    //时候直接返回
                    if (nodeValue == n) return level
                    //如果大于n，终止内层循环
                    if (nodeValue > n) break
                    if (!visited.contains(nodeValue)) {
                        queue.offer(nodeValue)
                        visited.add(nodeValue)
                    }
                }
            }
        }
        return level
    }

}