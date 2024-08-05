package week11.day6;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/4 17:12
 * <p>
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 * 解题思路：
 * 遍历两个数组，将gas和cost之差合并，当合并后的值比之前合并后的值更小或者相等，则出发位置index拟定为 i+1
 * 当遍历完数组后，两数组所有数之差的和小于0，则此题无解，否则出发位置为index % len （防止下标溢出）
 */
public class SolutionOne {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int temp = 0;
        int stem = Integer.MAX_VALUE;
        int index = 0;
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            temp += gas[i] - cost[i];
            if (temp <= stem) {
                stem = temp;
                index = i + 1;
            }
        }
        return temp < 0 ? -1 : index % len;
    }
}
