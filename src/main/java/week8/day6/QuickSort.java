package week8.day6;

import java.util.Random;

/**
 * @author LuoXuanwei
 * @date 2023/6/28 0:16
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {8, 4, 3, 7, 1, 5, 6, 2};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left;
            int k = right;
            Random random = new Random();
            int s = (left + random.nextInt(right - left));
            swap(nums, left, s);
            int x = nums[left];
            while (i < k) {
                while (i < right && nums[i] <= x) {
                    i++;
                }
                while (k > left && nums[k] > x) {
                    k--;
                }
                if (i < k) {
                    swap(nums, i, k);
                }
            }
            nums[left] = nums[k];
            nums[k] = x;
            quickSort(nums, left, k - 1);
            quickSort(nums, k + 1, right);
        }
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
