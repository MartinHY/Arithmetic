package structure.tree

import java.util.*
import javax.swing.tree.TreeNode

/**
 * 作者：MartinBZDQSM on 2021/9/24 14:25
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述 :
 * 二叉树遍历  , 其遍历的顺序实际上是指的根节点的顺序
 */
object 二叉树遍历 {
    @JvmStatic
    fun main(args: Array<String>) {
        val head = MyNode(1).apply {
            left = MyNode(2).apply {
                left = MyNode(4)
                right = MyNode(5)
            }
            right = MyNode(3).apply {
                left = MyNode(6)
                right = MyNode(7)
            }
        }
        println("前序遍历")
        before(head)
        println("中序遍历")
        center(head)
        println("后续遍历")
        after(head)
        println("层序遍历")
        floor(head)
    }

    private fun floor(head: MyNode<Int>) {
        val list = LinkedList<MyNode<Int>>()
        list.offer(head)
        while (list.isNotEmpty()){
            val node = list.pop()
            println(" ${node.t}")
            node.left?.let {  list.offer(it) }
            node.right?.let { list.offer(it) }
        }
    }

    fun before(head: MyNode<Int>){
        println("head.t ${head.t}")
        head.left?.let { before(it) }
        head.right?.let { before(it) }
    }

    fun center(head: MyNode<Int>){
        head.left?.let { center(it) }
        println("head.t ${head.t}")
        head.right?.let { center(it) }
    }


    fun after(head: MyNode<Int>){
        head.left?.let { after(it) }
        head.right?.let { after(it) }
        println("head.t ${head.t}")
    }

    class MyNode<T>(val t: T) {
        var left: MyNode<T>? = null
        var right: MyNode<T>? = null
    }
}