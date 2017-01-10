package com.martin;

import sun.applet.Main;

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
class FinalOverLoad {

    public void test() {
        System.out.println("FinalOverLoad");
    }

    /**
     * private 修饰符相当于隐性的添加了final ，都无法直接继承，当然你对着写 编译器也不会报错
     */
//    private  void test(){
//        System.out.println("FinalOverLoad");
//    }
//    public final void test(){
//        System.out.println("FinalOverLoad");
//    }

}

class OverridingPrivate extends FinalOverLoad {

    @Override
    public void test() {
        super.test();
    }
}



