package week2.day10;

import java.io.FileWriter;
import java.io.IOException;

public class Fullsort {
    static Queue<Integer> st = new Queue();
    static Queue<Integer> st1 = new Queue();
    //static Queue<Integer> waitqueue=new Queue();
    public static int[] data = {1, 2, 3, 4, 5};
    public static int sign = 1;
    public static int e;
    public static int count = 0;
    public static int sum = 0;//factorial
    public static int round = 0;//file
    public static int[] a = new int[data.length];

    public static int fn(int n) {
        if (n > 1) {
            sum += fn(n - 1) * n;
            return sum;
        } else {
            return sum;
        }
    }

    public static void init() {
        int index = 0;
        while (index < data.length) {
            st.push(data[index]);
            index++;
        }
    }

    public static void swap(int i, int j) {
        while (!st1.empty()) {
            st1.pop();
        }
        int index = 0;
        while (!st.empty()) {
            a[index] = st.pop();
            index++;
        }
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        index = 0;
        while (index < data.length) {
            st.push(a[index]);
            st1.push(a[index]);
            index++;
        }
    }

    public static void restore() {
        while (!st1.empty()) {
            st.push(st1.pop());
        }
    }

    public static void fullsort(int start, int len, FileWriter writer) throws IOException {
        //start point to the end one round finish
        if (start == len - 1) {
            while (!st.empty()) {
                int e = st.pop();
                System.out.print(e + " ");
                writer.write(e);
            }
            System.out.println();
            restore();
            writer.write("\n");
            count++;
        } else {
            for (int index = start; index < len; index++) {
                //run all the start
                swap(start, index);  // recursion
                fullsort(start + 1, len, writer);
                swap(start, index);  //Finish and restore
            }
        }
    }

    public static void main(String args[]) throws IOException {
        FileWriter writer = new FileWriter("src/main/java/day10/permutation.txt");
        init();
        fullsort(0, data.length, writer);
        System.out.print(count);
        writer.close();
    }
}

