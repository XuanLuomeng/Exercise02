package week1.day05.arraySplittingAndMerging;

import java.util.ArrayList;
import java.util.List;

public class IntegerSplittingAndSorting {
    public static void main(String[] args) {
        int[] numArray = {12, 15, 35, 151, 16, 654, 153, 135, 115, 531, 123, 54, 16, 68};
        System.out.println("原数组冒泡排序：");
        bubbling(numArray);
        for (int i = 0; i < numArray.length; i++) {
            System.out.print(numArray[i] + "\t");
        }
        System.out.println();
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> comNum = new ArrayList<>();
        for (int num = 0; num < numArray.length; num++) {
            if ((numArray[num] % 2) == 0) {
                even.add(numArray[num]);
            } else {
                odd.add(numArray[num]);
            }
        }
        int comTime = odd.size() > even.size() ? even.size() : odd.size();
        for (int time = 0; time < comTime; time++) {
            if (odd.get(time) > even.get(time)) {
                comNum.add(odd.get(time));
                comNum.add(even.get(time));
            } else {
                comNum.add(even.get(time));
                comNum.add(odd.get(time));
            }
        }
        System.out.println("奇偶对比排序后的数组：");
        for (int num = 0; num < comNum.size(); num++) {
            numArray[num] = comNum.get(num);
            System.out.print(numArray[num] + "\t");
        }
    }

    public static void bubbling(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
