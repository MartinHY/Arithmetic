package com.martin;

/**
 * 作者：MartinBZDQSM on 2016/9/12 0012.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 * <p/>
 * 题目描述：
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，
 * 输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class DArrarySearch {

    public static void main(String args[]) {
        final int[][] array = new int[][]{{1, 5, 9}, {2, 6, 10}, {3, 7, 11}, {4, 8, 12}};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.print("Result :" + find3(array, 5));
    }


    //迭代 ，时间复杂度
    public static boolean find1(int[][] array, int target) {
        int x = array.length;
        int y = array[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (array[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    //每一行开始二分查找
    public static boolean find2(int[][] array, int target) {
        int row = array.length;
        int col = array[0].length;
        for (int x = 0; x < row; x++) {
            int sign = (col - 1) / 2;
            while (sign > 0 && sign < col)
                if (array[x][sign] > target) {
                    sign--;
                } else if (array[x][sign] < target) {
                    sign++;
                } else {
                    return true;
                }
        }
        return false;
    }

    //从右上角开始查找
    public static boolean find3(int[][] array, int target) {
        int row = array.length;
        int col = array[0].length;
        int x = 0, y = col - 1;
        while (x < row && y >= 0) {
            if (array[x][y] > target) {
                y--;
            } else if (array[x][y] < target) {
                x++;
            } else {
                return true;
            }
        }
        return false;
    }

}
