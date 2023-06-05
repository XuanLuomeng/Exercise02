package week6.day3;

/**
 * @author LuoXuanwei
 * @date 2023/6/5 22:17
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        parm(nums, 0, nums.length - 1);
    }

    private static void parm(int[] nums, int start, int end) {
        if (start == end) {
            for (int num : nums) {
                System.out.print(num + "\t");
            }
            System.out.println();
        } else {
            for (int i = start; i <= end; i++) {
                swap(nums, start, i);
                parm(nums, start + 1, end);
                swap(nums, start, i);
            }
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
