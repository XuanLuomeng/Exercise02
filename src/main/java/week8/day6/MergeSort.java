package week8.day6;

/**
 * @author LuoXuanwei
 * @date 2023/6/28 0:09
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {23, 5, 7, 29, 14, 67};
        mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, mid, left, right);
    }

    private static void merge(int[] nums, int mid, int left, int right) {
        int[] newArray = new int[right - left + 1];
        int pointer = 0;
        int s1 = left;
        int s2 = mid + 1;
        while (s1 <= mid && s2 <= right) {
            if (nums[s1] < nums[s2]) {
                newArray[pointer++] = nums[s1++];
            } else {
                newArray[pointer++] = nums[s2++];
            }
        }
        while (s1 <= mid) {
            newArray[pointer++] = nums[s1++];
        }
        while (s2 <= right) {
            newArray[pointer++] = nums[s2++];
        }
        for (int i = 0; i < newArray.length; i++) {
            nums[left + i] = newArray[i];
        }
    }
}
