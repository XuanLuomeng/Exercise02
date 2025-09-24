package week15.day5;

import week2.day14.BubbleSort.List;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 合并区间
 * @date 2025/9/24 13:35
 *
 * 以数组 intervals 表示若干个区间的集合，
 * 其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 排序 + 双指针
 * 左端点排序，然后合并
 * 右端点比较
 */
public class Merge {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][2];
        }
        // 不能使用以下方法创建数组，因为数组长度是动态的
        //int[][] res = new int[intervals.length][2];

        // 给数组排序:左端点排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> res = new ArrayList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];

        // 遍历数组:右端点比较
        for (int i = 1; i < intervals.length; i++) {
            // 左端点小于右指针, 则更新右指针
            // 否则，将当前区间加入结果，并更新左指针和右指针
            if (intervals[i][0] <= right){
                right = Math.max(right, intervals[i][1]);
            } else {
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        // 将最后一个区间加入结果
        res.add(new int[]{left, right});

        return res.toArray(new int[res.size()][2]);
    }
}
