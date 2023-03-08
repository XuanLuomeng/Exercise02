package week4.day2;

public class Demo1 {
    public static void main(String[] args) {
        int[] list = {23, 5, 9, 16, 30, 25, 17, 18};
        int[] listTwo = {23, 5, 9, 16, 30, 25, 17, 18};
        mergeSort(list, 0, list.length - 1);
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int s1 = left;
        int s2 = mid + 1;
        int[] newArray = new int[right - left + 1];
        int pointer = 0;
        while (s1 <= mid && s2 <= right) {
            if (arr[s1] <= arr[s2]) {
                newArray[pointer++] = arr[s1++];
            } else {
                newArray[pointer++] = arr[s2++];
            }
        }
        while (s1 <= mid) {
            newArray[pointer++] = arr[s1++];
        }
        while (s2 <= right) {
            newArray[pointer++] = arr[s2++];
        }
        for (int i = 0; i < newArray.length; i++) {
            arr[i + left] = newArray[i];
        }
    }
}
