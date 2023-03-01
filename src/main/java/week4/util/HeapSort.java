package week4.util;

public class HeapSort {
    private int count;
    private int pointer;
    private int[] nums;

    public HeapSort(int[] nums) {
        this.count = nums.length;
        this.pointer = 0;
        this.nums = new int[count];
        for (int num : nums) {
            insert(num);
        }
    }

    private void insert(int num) {
        if (pointer >= count) {
            return;
        }
        nums[pointer] = num;
        int site = pointer;
        while (site / 2 >= 0 && nums[site] < nums[site / 2]) {
            int temp = nums[site];
            nums[site] = nums[site / 2];
            nums[site / 2] = temp;
            site = site / 2;
        }
        pointer += 1;
    }

    public void show() {
        for (int num : nums) {
            System.out.print(" " + num);
        }
        System.out.println();
    }
}
