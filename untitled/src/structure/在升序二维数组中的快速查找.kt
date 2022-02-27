package structure

/**
 * 作者：MartinBZDQSM on 2021/10/23
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述 :
 */
object 在升序二维数组中的快速查找 {
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

        println("旋转输出矩阵 : ${spiralOrder(matrix,10)}")
    }

    private fun spiralOrder(matrix: Array<IntArray>, taget :Int): String? {
        if (matrix.isEmpty()) return null
        var x =  matrix[0].size -1
        var y = 0
        while (x>=0 && y< matrix.size){
            if (taget==matrix[y][x])
                return "($x,$y)"
            else if (taget>matrix[y][x]){
                y++
            }else{
                x--
            }
        }
        return null
    }
}