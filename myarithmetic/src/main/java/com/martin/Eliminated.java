package com.martin;

import java.util.List;
import java.util.Vector;


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
public class Eliminated {


    public static void main(String args[]) {


//        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> orderlist = new Vector<>();
        System.out.print("顺序:");
        System.out.println();
        for (int i = 0; i < 10; i++) {
//            stack.push(i);
            orderlist.add(i);
            System.out.print(i + " ; ");
        }
        System.out.println();
        System.out.print("结果:");
        System.out.println();
        List<Integer> result = solve2(orderlist, null);
        for (int i : result) {
            System.out.print(i + " ; ");
        }

    }

    //另类的做法，默认list2是可以为空的,也就是说list1是从头开始数的部分
    public static List<Integer> solve2(List<Integer> list1, List<Integer> list2) {
        int tatolCount = list1.size();
        if (list2 != null && !list2.isEmpty()) {
            list1.addAll(list2);
            tatolCount += list2.size();
        }
        if (tatolCount > 6) {
            List<Integer> pre1 = new Vector<>();
            if (tatolCount > 7) {
                for (int i = 7; i < list1.size(); i++) {
                    pre1.add(list1.get(i));
                }
                list1.subList(6, list1.size()).clear();
            } else {
                list1.remove(6);
            }
            return solve2(pre1, list1);
        } else {
            return list1;
        }
    }

//    //听了同事使用栈的方式，感觉怪怪的，还是失败了，应该写的有问题
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
