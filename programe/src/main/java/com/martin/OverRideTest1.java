package com.martin;

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
public class OverRideTest1 {
    public static void main(String[] args) {
        new child();
    }

}


/**
 * Java保证了一个对象被初始化前其父类也必须被初始化。
 * 有下面机制来保证：Java强制要求任何类的构造函数中的第一句必须是调用父类构造函数或者是类中定义的其他构造函数。
 * 如果没有构造函数，系统添加默认的无参构造函数，如果我们的构造函数中没有显示的调用父类的构造函数，那么编译器自动生成一个父类的无参构造函数
 *
 * 构造器的初始化顺序大概是:父类静态块 ->子类静态块 ->父类初始化语句 ->父类构造函器 ->子类初始化语句 子类构造器。
 * 父类构造器执行的时候，调用了子类的重载方法，然而子类的类字段还在刚初始化的阶段，刚完成内存布局，只能输出null。
 */
class parent {
    private int i = 2;

    public parent() {
        System.out.println("parent parent ");
        display();
    }

    public void display() {
        System.out.println("parent display ");
        System.out.println("result:  " + i);
    }

}

class child extends parent {
    private  int i = 22;

    public child() {
        System.out.println("child child ");
        i = 222;
    }

    public void display() {
        System.out.println("child display ");
        System.out.println(i);
    }
}
