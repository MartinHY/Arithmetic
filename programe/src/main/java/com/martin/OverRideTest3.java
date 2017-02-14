package com.martin;

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
public class OverRideTest3 {

    int i = 0;

    public void Test1() {
        System.out.println(i);
    }

    public void Test2() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        OverRideTest3 test = new T2();
        test.Test1();
        test.Test2();
        System.out.println(test.i);
        test = (T2) test;
        System.out.println(test.i);
    }
}


class T2 extends OverRideTest3 {

    int i = 2;

    public void Test2() {
        System.out.println(i);
    }

}