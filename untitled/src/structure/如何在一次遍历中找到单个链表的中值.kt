package structure


/**
 * 作者：MartinBZDQSM on 2021/9/24 11:16
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述 :
 */
object 如何在一次遍历中找到单个链表的中值 {
    @JvmStatic
    fun main(args: Array<String>) {
        val head = MyNode(1).apply {
            next = MyNode(2).apply {
                next = MyNode(3).apply {
                    next = MyNode(4).apply {
                        next = MyNode(5).apply {
                            next = MyNode(6)
                        }
                    }
                }
            }
        }
        println("中值 : ${findCenterValue(head)?.t}")

    }

    private fun findCenterValue(head: MyNode<Int>): MyNode<Int>? {
        var node: MyNode<Int>? = head
        var index = 0
        var center: MyNode<Int>? = head
        while (node?.next != null) {
            node = node.next
            if (index % 2 == 0) {
                center = center?.next
            }
            index++
        }
        return center
    }


    class MyNode<T>(val t: T) {
        var next: MyNode<T>? = null
    }
}