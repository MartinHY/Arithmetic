package structure

import java.util.*

/**
 * 作者：MartinBZDQSM on 2021/9/24 09:43
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 *
 * 题目描述 : 用两个栈实现队列
 * 两个队列实现栈也是一样的道理
 */
object 用两个栈实现队列 {

    @JvmStatic
    fun main(args: Array<String>) {
        val mQueue = StackQueue<Int>()
        mQueue.offer(0)
        mQueue.offer(1)
        mQueue.offer(2)
        mQueue.offer(3)
        mQueue.offer(4)
        mQueue.offer(5)
        mQueue.offer(6)

        while (mQueue.isNotEmpty()){
            println("mQueue.pop () ${mQueue.poll()}")
        }

    }


    class StackQueue<T> : Queue<T>{

        /**
         * 暂存栈
         */
        var mStackA = Stack<T>()

        /**
         * 队列栈
         */
        var mStackB = Stack<T>()

        private fun pushStackInQueueStack(){
            while (mStackA.isNotEmpty()){
                mStackB.push(mStackA.pop())
            }
        }

        override fun add(element: T): Boolean {
           mStackA.push(element)
            return true
        }

        override val size: Int
            get() = mStackA.size + mStackB.size

        override fun addAll(elements: Collection<T>): Boolean {
            mStackA.addAll(elements)
            return true
        }

        override fun clear() {
            mStackA.clear()
            mStackB.clear()
        }

        override fun iterator(): MutableIterator<T> {
           return mStackB.iterator()
        }

        override fun remove(): T {
            return poll()
        }

        override fun contains(element: T): Boolean {
            return mStackA.contains(element)||mStackB.contains(element)
        }

        override fun containsAll(elements: Collection<T>): Boolean {
            return false
        }

        override fun isEmpty(): Boolean {
           return mStackA.isEmpty()&&mStackB.isEmpty()
        }

        override fun remove(element: T): Boolean {
            return mStackA.remove(element)||mStackB.remove(element)
        }

        override fun removeAll(elements: Collection<T>): Boolean {
            return false
        }

        override fun retainAll(elements: Collection<T>): Boolean {
            return false
        }

        override fun offer(e: T): Boolean {
            mStackA.push(e)
            return true
        }

        override fun poll(): T {
            pushStackInQueueStack()
            return mStackB.pop()
        }

        override fun element(): T {
            return peek()
        }

        override fun peek(): T {
            pushStackInQueueStack()
            return mStackB.peek()
        }

    }
}