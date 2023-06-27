package week7.day1;

/**
 * @author LuoXuanwei
 * @date 2023/6/8 18:55
 */
public class Partition {
    private static int[] nums = {2, 9, 11, 3, 14, 7, 10, 8, 15, 4, 13, 1, 6, 5, 12};

    public static void main(String[] args) {
        int select = select(0, nums.length, 8);
        System.out.println(select);
    }

    private static int select(int l, int r, int k) {
        if (r - l < 75) {
            bubble(l, r);
            return nums[l + k - 1];
        }
        for (int i = 0; i < (r - l - 4) / 5; i++) {
            int j = l + 5 * i, t = j + 4;
            for (int m = 0; m < 3; m++) {
                bubble(j, t - m);
            }
            swap(nums, l + i, j + 2);
        }
        int x = select(l, (r - l - 4) / 5, (r - l + 6) / 10);
        int i = partition(r, l, x), j = i - l + 1;
        if (k <= j) {
            return select(l, i, k);
        } else {
            return select(i + 1, r, k - j);
        }
    }

    //快排简化版
    private static int partition(int l, int r, int x) {
        int s = 0;
        for (int i = l; i < r; i++) {
            if (nums[i] == x) {
                s = i;
                break;
            }
        }
        int i = l, j = r + 1;
        while (true) {
            while (nums[++i] < x && i < r) {
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

    //将最小值放到最后(冒泡简化版)
    private static void bubble(int l, int r) {
        for (int j = l; j < r; j++) {
            if (nums[j] > nums[r - 1]) {
                int temp = nums[r - 1];
                nums[r - 1] = nums[j];
                nums[j] = temp;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
