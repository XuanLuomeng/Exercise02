package day05.shuffleCards;

import java.util.Random;

public class Gambler {
    public static void main(String[] args) {
        //Define the required tool variables
        final int half = 26;
        String[] poker = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10", "aj", "aq", "ak",
                "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10", "bj", "bq", "bk",
                "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10", "cj", "cq", "ck",
                "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "dj", "dq", "dk"};
        String[] poker1 = new String[half];
        String[] poker2 = new String[half];
        String[] poker3 = new String[half + 6];
        String[] poker4 = new String[half / 2 + 3];
        String[] poker5 = new String[half / 2 + 3];
        Random r = new Random();
        /**
         * Divide the original playing card array into two arrays in the middle,
         * and then add the two arrays back to the original array one by one
         */
        for (int num = 0; num < half; num++) {
            poker1[num] = poker[num];
            poker2[num] = poker[num + half];
        }
        for (int num = 0; num < half; num++) {
            poker[2 * num] = poker1[num];
            poker[2 * num + 1] = poker2[num];
        }
        //Shuffle the cards three times
        for (int time = 0; time < 3; time++) {
            //Sum the left and right values with half of the playing cards to get the number of cards drawn in the middle
            int left = r.nextInt(6) - 3;
            int right = r.nextInt(6) - 3;
            int ExNum = half + left + right;
            //Assign three separate sets of cards to three different arrays, and then re assign them to the original array
            for (int leftNum = 0; leftNum < (half / 2 - left); leftNum++) {
                poker4[leftNum] = poker[leftNum];
            }
            for (int rightNum = 0; rightNum < (half / 2 - right); rightNum++) {
                poker5[rightNum] = poker[ExNum + half / 2 - left + rightNum];
            }
            for (int middleNum = 0; middleNum < ExNum; middleNum++) {
                poker3[middleNum] = poker[half / 2 - left + middleNum];
            }
            int leOrRi = r.nextInt(1);
            /**
             * When the value of leorri is 0,
             * the card drawn in the middle is placed on the left side of the stack,
             * otherwise, it is placed on the right side of the stack
             */
            if (leOrRi == 0) {
                for (int leftNum = 0; leftNum < (half / 2 - left); leftNum++) {
                    poker[ExNum + leftNum] = poker4[leftNum];
                }
                for (int rightNum = 0; rightNum < (half / 2 - right); rightNum++) {
                    poker[ExNum + rightNum + (half / 2 - left)] = poker5[rightNum];
                }
                for (int middleNum = 0; middleNum < ExNum; middleNum++) {
                    poker[middleNum] = poker3[middleNum];
                }
            } else {
                for (int leftNum = 0; leftNum < (half / 2 - left); leftNum++) {
                    poker[leftNum] = poker4[leftNum];
                }
                for (int rightNum = 0; rightNum < (half / 2 - right); rightNum++) {
                    poker[(half / 2 - left) + rightNum] = poker5[rightNum];
                }
                for (int middleNum = 0; middleNum < ExNum; middleNum++) {
                    poker[half - left - right + middleNum] = poker3[middleNum];
                }
            }
        }
        //Output the shuffled results in the form of 4 * 13
        for (int row = 0; row < 4; row++) {
            for (int cols = 0; cols < 13; cols++) {
                System.out.print(poker[row * 13 + cols] + "\t");
            }
            System.out.println();
        }
    }
}
