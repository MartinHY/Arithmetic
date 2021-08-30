package structure;

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 *
 * 枚举类型 更还可以搭配switch使用
 */
public class EnumTest {

    public static void main(String[] args) {

        for (Spicniess s:Spicniess.values()){

            System.out.println("Spicniess name is : "+ s +" and the ordernal is: "+ s.ordinal());

        }

    }

}
