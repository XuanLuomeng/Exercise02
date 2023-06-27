package week8.day6;

/**
 * 线性时间选择(相对其他算法需要花费更多的时间进行理解和吸收知识)
 *
 * @author LuoXuanwei
 * @date 2023/6/28 0:30
 */
public class Partition {
    public static void main(String[] args) {
        int[] nums = {2, 9, 11, 3, 14, 7, 10, 8, 15, 4, 13, 1, 6, 5, 12};
        int select = select(nums, 0, nums.length, 8);
        System.out.println(select);
    }

    private static int select(int[] nums, int left, int right, int k) {
        if (right - left < 75) {
            bubble(nums, left, right);
            return nums[left + k - 1];
        }
        for (int i = 0; i < (right - left - 4) / 5; i++) {
            int j = left + i * 5, t = j + 4;
            for (int l = 0; l < 3; l++) {
                bubble(nums, j, t - l);
            }
            swap(nums, left + i, j + 2);
        }
        int x = select(nums, left, (right - left - 4) / 5, (right - left + 6) / 10);
        int i = quickSort(nums, left, right, x), j = i - left + 1;
        if (k <= j) {
            return select(nums, left, i, k);
        } else {
            return select(nums, i + 1, right, k);
        }
    }

    private static int quickSort(int[] nums, int left, int right, int x) {
        int s = 0;
        for (int i = left; i < right; i++) {
            if (nums[i] == x) {
                s = i;
            }
        }
        int i = left, j = right + 1;
        while (true) {
            while (i < right && nums[++i] < x) {
            }
            while (nums[--j] > x) {
            }
            if (i >= j) {
                break;
            }
        }
        nums[s] = nums[j];
        nums[j] = x;
        return j;
    }

    private static void bubble(int[] nums, int left, int right) {
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[right - 1]) {
                int temp = nums[i];
                nums[i] = nums[right - 1];
                nums[right - 1] = temp;
            }
        }
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
