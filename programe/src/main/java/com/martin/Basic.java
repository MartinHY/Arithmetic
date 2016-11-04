package com.martin;

/**
 * 作者：MartinBZDQSM on 2016/9/13 0013.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
public class Basic {


    //冒泡排序
    public static void sort1(int[] args) {
        for (int i = args.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (args[j] > args[i]) {
                    int temp = args[j];
                    args[j] = args[i];
                    args[i] = temp;
                }
            }
        }
    }

    //选择排序
    public static void sort2(int[] args) {
        for (int i=0, k=0;i<args.length;i++,k=i){
            for (int j=0;j<i;j++){
                if (args[j]>args[i]){
                    k=j;
                }
            }
            if (k!=i){
                int temp = args[k];
                args[k] = args[i];
                args[i] = temp;
            }
        }
    }

}
