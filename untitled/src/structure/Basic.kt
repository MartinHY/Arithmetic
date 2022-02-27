package structure

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
object Basic {
    @JvmStatic
    fun main(args: Array<String>) {
        var array = arrayListOf(1, 10, 23, 54, 11, 0, 3, 1, 66, 44, 92, 6, 91)
        bubbleSort(array)
        println("冒泡排序後的結果 :  $array")
        array = arrayListOf(1, 10, 23, 54, 11, 0, 3, 1, 66, 44, 92, 6, 91)
        chooseSort(array)
        println("选择排序後的結果 :  $array")
        array = arrayListOf(1, 10, 23, 54, 11, 0, 3, 1, 66, 44, 92, 6, 91)
        stickSort(array)
        println("插入排序後的結果 :  $array")
    }

    /**
     * 插入排序 , 从选中位置往前排 , 小的就往前面走 ,
     */
    private fun stickSort(array: java.util.ArrayList<Int>) {
        val length = array.size
        if (length < 2) return
        for (i in 1 until length) {
            val value  = array[i]
            var position = i
            while (position > 0 && array[position -1] > value) {
                array[position] = array[position-1]
                position--
            }
            array[position] = value
        }
    }

    /**
     * 选择排序 , 把后面最小的给换到前面来
     */
    private fun chooseSort(array: ArrayList<Int>) {
        val length = array.size
        for (i in 0 until length) {
            var k = i
            for (j in i + 1 until length) {
                if (array[j] < array[k]) {
                    k = j
                }
            }
            if (k != i) {
                val temp = array[i]
                array[i] = array[k]
                array[k] = temp
            }
        }
    }

    /**
     * 冒泡排序 , 相邻比较的目的是把最大的往后面排  , 这样排序的目的就达到了
     */
    private fun bubbleSort(array: ArrayList<Int>) {
        val length = array.size - 1
        for (i in length downTo 0) {
            for (j in 0 until i) {
                if (array[j] > array[j + 1]) {
                    val temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                }
            }
        }
    }


}