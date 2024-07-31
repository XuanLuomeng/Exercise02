package week11.day1;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/7/30 19:21
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class SolutionThree {

    private static final int[] nums = {1, 1, 1, 2, 2, 3};

    public static void main(String[] args) {
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int l = 0;
        int r = l + 1;
        int count = 0;
        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                l++;
                count = 0;
                nums[l] = nums[r];
            } else if (count < 1 && nums[l] == nums[r]) {
                l++;
                count++;
                nums[l] = nums[r];
            }
            r++;
        }
        return ++l;
    }
}
