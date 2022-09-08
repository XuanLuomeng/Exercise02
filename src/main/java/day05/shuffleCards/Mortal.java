package day05.shuffleCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mortal {
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
        List<String> array = new ArrayList<>();
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
         *Each side of the deck defines a variable for the number of cards drawn and the number of cards not drawn,
         * and a variable for the number of cards draw at random. First, randomly draw the number of 0-3 on one side to
         * determine whether the number of remaining cards is greater than or equal to 0.
         * If it is consistent, then draw the random number of cards and add them to array. Then exit the cycle and turn
         * to the other side if the card pile to do the same operation. Loop the above operation until the deck number
         * on both sides is 0, exit the loop.
         */
        int lNum = (half + lOrR);
        int lNum1 = 0;
        int rNum = (half - lOrR);
        int rNum1 = 0;
        int getNum;
        while (true) {
            while (true) {
                getNum = r.nextInt(3);
                if ((lNum - getNum) >= 0) {
                    for (int num = 0; num < getNum; num++) {
                        array.add(poker1[lNum1++]);
                    }
                    break;
                }
            }
            while (true) {
                getNum = r.nextInt(3);
                if ((rNum - getNum) >= 0) {
                    for (int num = 0; num < getNum; num++) {
                        array.add(poker2[rNum1++]);
                    }
                    break;
                }
            }
            if ((rNum == 0) && (lNum == 0)) {
                break;
            }
        }
        for (int num = 0; num < array.size(); num++) {
            poker[num] = array.get(num);
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
