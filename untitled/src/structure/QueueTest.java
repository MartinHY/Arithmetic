package structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
public class QueueTest {


    /**
     * Queue使用时要尽量避免Collection的add()和remove()方法，
     * 而是要使用offer()来加入元素，使用poll()来获取并移出元素。
     * 它们的优点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。
     * 如果要使用前端而不移出该元素，使用 element()或者peek()方法。
     */
    public static void main(String[] args) {
        Queue<String> stringQueue = new LinkedList<>();

        stringQueue.offer("a");
        stringQueue.offer("b");
        stringQueue.offer("c");
        stringQueue.offer("d");
        System.out.println("stringQueue.peek() 1 : " + stringQueue.peek());
        stringQueue.poll();
        System.out.println("stringQueue.peek() 2 : " + stringQueue.peek());
        for (String str : stringQueue) {
            System.out.println(str);
        }


    }

}
