package structure

/**
 * 作者：MartinBZDQSM on 2021/10/25
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 * 题目描述 :
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
object 找出数组中重复的数字 {

    @JvmStatic
    fun main(args: Array<String>) {
        val array =  intArrayOf(3, 4, 1, 1, 2, 5,0 )
        val result :Int = fundRepeat(array)
        println("result : $result")
    }

    private fun fundRepeat(array: IntArray): Int {
        array.forEachIndexed{index, i ->
            while (index != array[index]){
                if (array[index] == array[array[index]]){
                    return array[index]
                }
                val a = array[array[index]]
                array[array[index]] = array[index]
                array[index] = a
            }
        }
        return -1
    }
}