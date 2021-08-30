package structure;

/**
 * 作者：MartinBZDQSM on 2017/02/13
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 * 笔试题
 */
public class Example {
    String str = new String("good");//按值传递 靠
    char[] ch = {'a', 'b', 'c'};//按引用传递

    public static void main(String args[]) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }
}