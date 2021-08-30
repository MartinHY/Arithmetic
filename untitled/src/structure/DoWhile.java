package structure;

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 * <p>
 * 区分do-while 和 while-do 的区别
 */
public class DoWhile {


    public static void main(String[] args) {

        doWhile(0);
        whileDo(0);
    }


    /**
     * 两个方法的主要区别在于：do-while 不管条件与否都会先执行一次
     * 而while-do需要判断完全条件再执行
     */

    public static void doWhile(int i) {
        do {
            i--;
            System.out.println("doWhile");
        } while (i > 0);
    }

    public static void whileDo(int i) {
        while (i > 0) {
            i--;
            System.out.println("whileDo");
        }
    }


}
