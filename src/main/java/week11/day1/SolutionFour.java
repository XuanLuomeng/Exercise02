package week11.day1;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/7/30 20:00
 * <p>
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 方法1：
 * System.arraycopy(nums,x,ans,y,z)
 * 将nums中第x-1个元素开始复制z个元素给ans从y的位置开始
 * <p>
 * 方法2：
 * 将数组倒置（反转）
 * 注意！！！该方法只适用于轮转次数小于数组长度
 * 将数组当中0至k-1的元素和k至len-1的元素分别倒置（反转）
 */
public class SolutionFour {
    public void rotate(int[] nums, int k) {
        //System.arraycopy复制
        int len = nums.length;
        int[] newNums = new int[len * 2];
        System.arraycopy(nums, 0, newNums, 0, len);
        System.arraycopy(nums, 0, newNums, len, len);
        System.arraycopy(newNums, len - (k % len), nums, 0, len);
        //方法2数组倒置
//        re(nums, 0, nums.length);
//        re(nums, 0, k - 1);
//        re(nums, k, nums.length - 1);
    }

    public void re(int[] nums, int x, int y) {
        while (x < y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
            x++;
            y--;
        }
    }
}
