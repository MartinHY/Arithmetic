package com.martin;

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 * 题目描述：
 * 将“I am ok” 转换成“ok am I”
 */
public class StringReverse {

    public static void main(String args[]) {

        String str = "I love you";
        System.out.print(str);
        System.out.println();
        String[] strs = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            stringBuilder.append(strs[i] + " ");
        }
        System.out.print(stringBuilder.toString());
    }

}
