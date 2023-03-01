package week3.day19;

import java.util.ArrayList;

public class Kruskal {
    public static final String[] node = {"v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8", "v9", "v10", "v11"};
    public static final int[][] matrix = {{0, 2, 8, 1, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 6, 0, 1, 0, 0, 0, 0, 0, 0},
            {8, 6, 0, 7, 5, 1, 2, 0, 0, 0, 0},
            {1, 0, 7, 0, 0, 0, 9, 0, 0, 0, 0},
            {0, 1, 5, 0, 0, 3, 0, 2, 9, 0, 0},
            {0, 0, 1, 0, 3, 0, 4, 0, 6, 0, 0},
            {0, 0, 2, 9, 0, 4, 0, 0, 3, 1, 0},
            {0, 0, 0, 0, 2, 0, 0, 0, 7, 0, 9},
            {0, 0, 0, 0, 9, 6, 3, 7, 0, 1, 2},
            {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 4},
            {0, 0, 0, 0, 0, 0, 0, 9, 2, 4, 0}};
    public static final int nodeNum = 11;
    public static final int border = 22;

    public static void main(String[] args) {
        /**
         * Put the start and end points and their weights into the list
         */
        ArrayList<WeightedAdjacentMatrix> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    WeightedAdjacentMatrix weightedAdjacentMatrix = new WeightedAdjacentMatrix(node[i], node[j], matrix[i][j]);
                    list.add(weightedAdjacentMatrix);
                }
            }
        }
        /**
         * Sort the list according to its weight
         */
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).weight > list.get(j + 1).weight) {
                    WeightedAdjacentMatrix temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        int sign = 0;
        for (int side = 0; side < list.size(); side++) {
            if (sign == nodeNum - 1) {
                break;
            } else {
                sign++;
            }
            System.out.println(list.get(side).start + "\t" + list.get(side).end + "\t" + list.get(side).weight);
            /**
             * The used and repeated edges are removed
             */
            for (int i = 0; i < list.size(); i++) {
                if ((list.get(i).start.equals(list.get(side).end)) && (list.get(i).end.equals(list.get(side).start))) {
                    if (i > side) {
                        list.remove(i);
                        list.remove(side);
                    } else {
                        list.remove(side);
                        list.remove(i);
                    }
                    side = 0;
                    break;
                }
            }
        }
    }
}
