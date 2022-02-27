package structure

/**
 * 作者：MartinBZDQSM on 2022/2/21
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述 :
 */
object 反转单向链表 {

    @JvmStatic
    fun main(args: Array<String>) {
        val head = Node(1).apply {
            next = Node(2).apply {
                next = Node(3).apply {
                    next = Node(4).apply {
                        next = Node(5).apply {
                            next = Node(6)
                        }
                    }
                }
            }
        }
        var node:Node<Int>?= reverseNode(head)
        while (node !=null){
            println("反转 : $node")
            node = node.next
        }
    }

    private fun reverseNode(head: Node<Int>): Node<Int>? {
        var lastNode :Node<Int>?=null
        var node:Node<Int>?= head
        while (node !=null){
            val next = node.next
            node.next = lastNode
            lastNode = node
            node = next
        }
        return lastNode
    }

    class Node<T>(val t: T) {
        var next: Node<T>? = null
        override fun toString(): String {
            return t.toString()
        }
    }
}