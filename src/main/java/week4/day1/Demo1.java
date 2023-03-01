package week4.day1;

import week4.util.HeapSort;

public class Demo1 {
    public static void main(String[] args) {
        int[] nums = {25, 30, 11, 7, 22, 16, 18, 33, 40, 55};
        HeapSort hs = new HeapSort(nums);
        hs.show();
    }
}
