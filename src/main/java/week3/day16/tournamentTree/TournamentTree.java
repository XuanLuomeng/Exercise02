package week3.day16.tournamentTree;

import week1.day03.util.ReadFile;

import java.io.IOException;
import java.util.Arrays;

public class TournamentTree {
    public static void main(String[] args) throws IOException {
        /**
         * Get an array from a file
         */
        String file = "src/main/java/day16/datafile.txt";
        int[] array;
        ReadFile rf = new ReadFile();
        array = rf.read(file, 10000);
        //tournamentTree
        tournamentTree(array);
        //show
        System.out.println(Arrays.toString(array));
    }

    public static void tournamentTree(int[] arr) {
        int[] array = new int[arr.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = winner(arr);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == array[i]) {
                    arr[j] = 0;
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
        }
    }

    public static int winner(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[] newArray = arr.length % 2 == 0 ? new int[arr.length / 2] : new int[arr.length / 2 + 1];
        int index = 0;
        for (; index < arr.length / 2; index++) {
            newArray[index] = arr[2 * index] > arr[2 * index + 1] ? arr[2 * index] : arr[2 * index + 1];
        }
        if (index != newArray.length) {
            newArray[index] = arr[arr.length - 1];
        }
        return winner(newArray);
    }
}
