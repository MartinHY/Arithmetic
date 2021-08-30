import kotlin.jvm.JvmStatic
import java.util.Vector

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 * 题目描述：
 * 10个人轮着数数，
 * 从1开始，数到7的人就出局，
 * 然后后面那个人从1开始继续数，直至数不完为止
 * 写个方法，求剩下的人。
 */
object Eliminated {
    @JvmStatic
    fun main(args: Array<String>) {


//        Stack<Integer> stack = new Stack<Integer>();
        val orderlist: MutableList<Int> = Vector()
        print("顺序:")
        println()
        for (i in 1..10) {
//            stack.push(i);
            orderlist.add(i)
            print("$i ; ")
        }
        println()
        print("结果:")
        println()
        val result = solve2(orderlist, null)
        for (i in result) {
            print("$i ; ")
        }
    }

    //比较愚蠢的做法，默认list2是可以为空的,也就是说list1是从头开始数的部分
    fun solve2(list1: MutableList<Int>, list2: List<Int>?): List<Int> {
        var tatolCount = list1.size
        if (list2 != null && !list2.isEmpty()) {
            list1.addAll(list2)
            tatolCount += list2.size
        }
        return if (tatolCount > 6) {
            val pre1: MutableList<Int> = Vector()
            if (tatolCount > 7) {
                for (i in 7 until list1.size) {
                    pre1.add(list1[i])
                }
                list1.subList(6, list1.size).clear()
            } else {
                list1.removeAt(6)
            }
            solve2(pre1, list1)
        } else {
            list1
        }
    } //    //听了同事使用栈的方式，感觉怪怪的，还是失败了，应该写的有问题
    //    public static Stack<Integer> solve1(Stack<Integer> stack) {
    //
    //        if (stack.size() > 6) {
    //            Stack<Integer> preStack = new Stack<Integer>();
    //            List<Integer> pre1 = new Vector<>();
    //            List<Integer> pre2 = new Vector<>();
    //            System.out.print("第二次入栈:" + stack.size());
    //            System.out.println();
    //            for (int i = 0; i < stack.size(); i++) {
    //                //不知道为何这里只输出到5了
    ////                System.out.print(" stack.pop() :" + stack.pop());
    ////                System.out.println();
    //                if (i < 6) {
    //                    pre1.add(stack.pop());
    //                } else if (i > 6) {
    //                    pre2.add(stack.pop());
    //                } else {
    //
    //                }
    //            }
    //            for (int k = pre2.size() - 1; k >= 0; k--) {
    //                preStack.push(pre2.get(k));
    ////                System.out.print(pre2.get(k) + " ; ");
    //            }
    //
    //            for (int i = 0; i < pre1.size(); i++) {
    //                preStack.push(pre1.get(i));
    ////                System.out.print(pre1.get(i) + " ; ");
    //            }
    //            return stack;
    //        } else {
    //            return stack;
    //        }
    //    }
}