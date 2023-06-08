package week6.day7;

import java.util.Random;

/**
 * @author LuoXuanwei
 * @date 2023/6/8 18:28
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
            int l = left;
            int r = right;
            Random random = new Random();
            swap(nums, left, (left + random.nextInt(right - left)));
            int x = nums[left];
            while (l < r) {
                while (l < right && nums[l] <= x) {
                    l++;
                }
                while (r > left && nums[r] > x) {
                    r--;
                }
                if (l < r) {
                    swap(nums, l, r);
                }
            }
            nums[left] = nums[r];
            nums[r] = x;
            quickSort(nums, left, r - 1);
            quickSort(nums, r + 1, right);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
