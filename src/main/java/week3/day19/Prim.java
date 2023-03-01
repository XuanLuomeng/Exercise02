package week3.day19;

import java.util.ArrayList;

public class Prim {
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

        String end = "v1";
        int sign = 0;
        ArrayList<String> strList = new ArrayList<>();
        strList.add("v1");
        while (sign != nodeNum - 1) {
            ArrayList<WeightedAdjacentMatrix> arrayList = new ArrayList<>();
            WeightedAdjacentMatrix signMat = new WeightedAdjacentMatrix();
            for (int i = 0; i <= sign; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).start.equals(strList.get(i)) && (!end.contains(list.get(j).end))) {
                        if (!end.contains(list.get(j).end)) {
                            arrayList.add(list.get(j));
                        }
                    }
                }
            }
            signMat = arrayList.get(0);
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i).weight < signMat.weight) {
                    signMat = arrayList.get(i);
                }
            }
            System.out.println(signMat.start + "\t" + signMat.end + "\t" + signMat.weight);
            strList.add(signMat.end);
            end += signMat.end;
            sign++;
        }
    }
}
