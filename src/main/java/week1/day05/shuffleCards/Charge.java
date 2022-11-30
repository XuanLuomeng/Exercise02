package week1.day05.shuffleCards;

import java.util.Random;

public class Charge {
    public static void main(String[] args) {
        //Define the required tool variables
        final int half = 26;
        String[] poker = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10", "aj", "aq", "ak",
                "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10", "bj", "bq", "bk",
                "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10", "cj", "cq", "ck",
                "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "dj", "dq", "dk"};
        String[] poker1 = new String[half + 3];
        String[] poker2 = new String[half + 3];
        String[] poker3 = new String[half + 6];
        String[] poker4 = new String[half / 2 + 3];
        String[] poker5 = new String[half / 2 + 3];
        Random r = new Random();
        /**
         *Get a random number ranging from -3 to 3.
         * Negative x takes less x on the left side,
         * more x on the other side,and positive x takes the opposite.
         */
        int lOrR = r.nextInt(6) - 3;
        for (int left = 0; left < (half + lOrR); left++) {
            poker1[left] = poker[left];
        }
        for (int right = 0; right < (half - lOrR); right++) {
            poker2[right] = poker[half + lOrR + right];
        }
        /**
         * First get two piles of cards only difference, and then the least side of the number of cards to cycle will be two
         * piles of cards a given the original array,and then the number of cards on the side of the last few cards into the
         * original array. If the number of cards on both sides is the same , then directly carry out two piles of cards respectively
         * one by one back to the original array.
         */
        int many = 2 * lOrR;
        if (many < 0) {
            for (int Num = 0; Num < (half + lOrR); Num++) {
                poker[2 * Num] = poker1[Num];
                poker[2 * Num + 1] = poker2[Num];
            }
            for (int Num = (half + lOrR); Num < (half - lOrR); Num++) {
                poker[half + lOrR + Num] = poker2[Num];
            }
        } else if (many > 0) {
            for (int Num = 0; Num < (half - lOrR); Num++) {
                poker[2 * Num + 1] = poker2[Num];
                poker[2 * Num] = poker1[Num];
            }
            for (int Num = (half - lOrR); Num < (half + lOrR); Num++) {
                poker[half - lOrR + Num] = poker1[Num];
            }
        } else {
            for (int num = 0; num < half; num++) {
                poker[2 * num] = poker1[num];
                poker[2 * num + 1] = poker2[num];
            }
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
