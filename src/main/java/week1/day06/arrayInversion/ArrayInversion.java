package week1.day06.arrayInversion;

import java.io.IOException;
import java.util.Random;

public class ArrayInversion {
    public static void main(String[] args) throws IOException {
        /**
         * Initialize Data
         */
        int[] array = new int[50];
        Random r = new Random();
        int max = 0;
        int side = 0;
        /**
         * Generate arrays by random assignment as required
         */
        for (int position = 0; position < array.length; position++) {
            if (position < 10 || position >= 40) {
                array[position] = r.nextInt(20);
            } else if ((position < 20 && position >= 10) || (position < 40 && position >= 30)) {
                array[position] = r.nextInt(20) + 20;
            } else {
                array[position] = r.nextInt(20) + 40;
            }
        }
        /**
         *Output initial array
         */
        System.out.println("生成的随机数组：");
        for (int position = 0; position < array.length; position++) {
            System.out.print(array[position] + ",");
        }
        System.out.println();
        /**
         * Find the subscript of the maximum number
         */
        for (int position = 20; position < 30; position++) {
            if (array[position] > max) {
                max = array[position];
                side = position;
            }
        }
        long start = System.nanoTime();
        /**
         * Invert the number in front of the largest number in the array
         */
        for (int position = 0; position < side / 2; position++) {
            int temp = 0;
            temp = array[position];
            array[position] = array[side - 1 - position];
            array[side - 1 - position] = temp;
        }
        /**
         * Invert the number after the largest number in the array
         */
        for (int position = 0; position < (array.length - side) / 2; position++) {
            int temp = 0;
            temp = array[array.length - position - 1];
            array[array.length - position - 1] = array[side + 1 + position];
            array[side + 1 + position] = temp;
        }
        long end = System.nanoTime();
        /**
         *Output the array with the maximum left and right numbers inverted
         */
        System.out.println("最大数前后数字倒置后的数组：");
        for (int position = 0; position < array.length; position++) {
            System.out.print(array[position] + ",");
        }
        System.out.println();
        System.out.println("总用时：" + (end - start) + "ns");
    }
}
