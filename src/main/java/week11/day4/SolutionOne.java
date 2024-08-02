package week11.day4;

import java.util.Arrays;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/2 20:35
 * <p>
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * <p>
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * <p>
 * 即：寻找一个数 h，h 表示 citations 数组中至少有 h 个数，并且这 h 个数都大于等于 h。
 */
public class SolutionOne {

    public int hIndex(int[] citations) {
        int len = citations.length;
        int res = 0;
        int[] cit = new int[len + 1];
        for (int x : citations) {
            cit[Math.min(len, x)]++;
        }
        for (int i = len; ; i--) {
            res += cit[i];
            if (i <= res) {
                return i;
            }
        }
    }
}
