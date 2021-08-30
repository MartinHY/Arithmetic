package structure;

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
public class Property {

    String name = "Martin";

    public final String getName() {
        final String field = name;
        return field.toUpperCase();
    }

    public final void setName(String name) {
        final String field = ("Name:" + name);
        this.name = field;
    }

    public static void main(String[] args) {
        Property property = new Property();
        property.getName();
        property.setName("Martin 太帅了");
    }
}
