package week3.day17.sumSearch;

import week1.day03.util.ReadFile;

import java.io.IOException;
import java.util.LinkedList;

public class SumSearch {
    public static void main(String[] args) throws IOException {
        /**
         * Get an array from a file
         */
        String file = "src/main/java/day17/datafile.txt";
        int[] array;
        ReadFile rf = new ReadFile();
        array = rf.read(file, 10000);
        //bucketSort
        radixSort(array);
        //sumSearch
        int target = 29340;
        int result = SumSearch(array, 0, array.length - 1, target);
        if (result != -1) {
            System.out.println("查找成功");
        } else {
            System.out.println("查找失败");
        }
    }

    public static void radixSort(int[] arr) {
        int radix = getRadix(arr);
        LinkedList<Integer>[] list = new LinkedList[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }
        //The number of cycles is determined according to the number of bits of the maximum value
        for (int r = 1; r <= radix; r++) {
            //Dispatch to buckets
            for (int i = 0; i < arr.length; i++) {
                list[getIndex(arr[i], r)].addLast(arr[i]);
            }
            int index = 0;
            //Pop the number of each bucket
            for (int i = 0; i < list.length; i++) {
                while (!list[i].isEmpty()) {
                    arr[index++] = list[i].remove();
                }
            }
        }
    }

    private static int getIndex(int num, int r) {
        int ret = 0;
        for (int i = 1; i <= r; i++) {
            ret = num % 10;
            num /= 10;
        }
        return ret;
    }

    private static int getRadix(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return (max + "").length();
    }

    public static int SumSearch(int arr[], int low, int high, int target) {
        if (low > high) {
            return -1;
        } else {
            int result = arr[low] + arr[high];
            if (target < result) {
                return SumSearch(arr, low, high - 1, target);
            } else if (target > result) {
                return SumSearch(arr, low + 1, high, target);
            } else {
                System.out.println(arr[low] + "+" + arr[high] + "=" + target);
                return result;
            }
        }
    }
}
