package week15.day7;

import java.util.Arrays;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 用最少的箭引爆气球
 * @date 2025/9/26 15:54
 * <p>
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * <p>
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 */
public class FindMinArrowShots {
    public static void main(String[] args) {
//        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(findMinArrowShots2(points));
    }

    // 以第一个数组的右端点为区间右端点
    // 遍历数组(跳过第一个数组)，如果当前气球的左端点小于等于当前区间的右端点
    // 则说明有重叠，继续遍历下一个气球
    // 直至没有重叠区间，将当前区间的右端点作为区间的右端点，飞镖数+1，并继续遍历下一个气球
    public static int findMinArrowShots2(int[][] points) {
        int n = points.length;
        if (n == 0) {
            return 0;
        }

        // 按区间的右端点排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrow = 1;
        int right = points[0][1];
        for (int i = 1; i < n; i++) {
            if (points[i][0] > right) {
                arrow++;
                right = points[i][1];
            }
        }

        return arrow;
    }

    // 解题思路1: 区间重叠则用交集合并为一个区间
    public static int findMinArrowShots1(int[][] points) {
        int n = points.length;
        if (n == 0) {
            return 0;
        }

        // 按区间的左端点排序
        // 使用Integer.compare的原因是防止相减的结果造成溢出
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int arrow = points.length;
        for (int i = 1; i < n; i++) {
            if (points[i - 1][1] >= points[i][0]) {
                arrow--;
                points[i][0] = Math.max(points[i - 1][0], points[i][0]);
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }

        return arrow;
    }
}
