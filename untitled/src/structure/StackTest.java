package structure;

import java.util.Stack;

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
public class StackTest {


    /**
     * 栈满足后入先出的规则，主要方法有：push 入栈， pop出栈 ，peek查看栈顶
     */
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        stringStack.push("d");
        stringStack.push("e");
        System.out.println(" stringStack.peek() 1 : " + stringStack.peek());
        System.out.println(" stringStack.pop()  : " + stringStack.pop());
        System.out.println(" stringStack.peek() 2 : " + stringStack.peek());


    }
}
