package week15.day6;

import java.util.ArrayList;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 插入区间
 * @date 2025/9/25 22:14
 * <p>
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 * <p>
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 返回插入之后的 intervals。
 * <p>
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 */
public class InsertScope {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        for(int[] interval : insert(intervals, newInterval)){
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    /**
     * 遍历每个区间，判断是否需要合并
     * 在新区间的左边界外的数组可以直接插入
     * 在左右边界内的数组，将两个数组进行合并为新数组
     * 在新区间的右边界外的数组直接将新数组插入，然后将新数组变为当前遍历的数组
     * 最后将最后剩余的一个数组插入
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }

        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                arrayList.add(interval);
            } else if (interval[0] > newInterval[1]) {
                arrayList.add(newInterval);
                newInterval = interval;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        arrayList.add(newInterval);

        return arrayList.toArray(new int[arrayList.size()][]);
    }
}
