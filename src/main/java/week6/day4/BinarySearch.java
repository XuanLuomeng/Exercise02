package week6.day4;

/**
 * @author LuoXuanwei
 * @date 2023/6/6 23:50
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 8, 12, 15, 16, 21, 30, 35, 39};
        int s = 13;
        int i = binarySearch(nums, s, nums.length - 1);
        if (i != -1) {
            System.out.println(s + "的位置为" + i);
        }
    }

    private static int binarySearch(int[] nums, int s, int len) {
        int left = 0;
        int right = len;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == s) {
                return mid;
            } else if (nums[mid] > s) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (nums[mid] > s && nums[mid - 1] < s) {
                System.out.println("无" + s + "这个数字，但数组中小于该数字的最大元素位置和大于该数字的最小元素位置分别为" + (mid - 1) + "，" + mid);
            } else if (nums[mid] < s && nums[mid + 1] > s) {
                System.out.println("无" + s + "这个数字，但数组中小于该数字的最大元素位置和大于该数字的最小元素位置分别为" + mid + "，" + (mid + 1));
            }
        }
        return -1;
    }
}
