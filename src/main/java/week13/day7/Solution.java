package week13.day7;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2025/3/19 19:37
 */

/**
 * 题目:
 * 数组中找出所有满足条件的数，要求该数比前面的都大，比后面的都小，首尾数不输出。
 * 特征: 从下标1开始比较，只要有一个不符合要求，后面的所有数都不符合要求
 * 解题思路: 滑动窗口/双指针
 * 只需要判断后续数字中最小值比当前指针的数字大以及前一个数字比当前指针的数字小(此判断防止第一次判断出错)即可。
 * 示例 1:
 * 输入:[-1.1, 3, 7, 79.6, 9.8]
 * 输出:[3.00000,7.00000]
 * 示例 2:
 * 输入:[-5, -2.2, 19, 28, 19, -1.5]
 * 输出:[-2.20000]
 * 示例 3:
 * 输入:[0, -2.2, 11, 22, 15, -18]
 * 输出:[]
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param data double浮点型一维数组
     * @return double浮点型ArrayList
     */
    public ArrayList<Double> findPoints(double[] data) {
        // write code here
        ArrayList<Double> list = new ArrayList<>();
        if (data.length < 2) {
            return list;
        }
        for (int i = 1; i < data.length - 1; i++) {
            double min = Integer.MAX_VALUE;
            for (int j = i + 1; j < data.length; j++) {
                min = Math.min(min, data[j]);
            }
            if (data[i] < min && data[i - 1] < data[i]) {
                list.add(data[i]);
            }
        }
        return list;
    }
}
