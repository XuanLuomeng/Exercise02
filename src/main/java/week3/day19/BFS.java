package week3.day19;

import java.util.*;

public class BFS {
    public static AdjacentMatrix matrix = new AdjacentMatrix();

    public static void main(String[] args) {
        /**
         * BFS is implemented using the adjacency list.
         * Building an adjacency list.
         */
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < matrix.matrix.length; i++) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < matrix.matrix[i].length; j++) {
                if (matrix.matrix[i][j] != 0) {
                    list.add(matrix.node[j]);
                }
            }
            map.put(matrix.node[i], list);
        }
        System.out.println("以v1为起始点");
        BFS("v1", map);
        System.out.println("以v8为起始点");
        BFS("v8", map);
    }

    public static void BFS(String start, HashMap<String, ArrayList<String>> map) {
        ArrayList<String> queue = new ArrayList<>();
        ArrayList<String> visit = new ArrayList<>();
        String key = null;
        queue.add(start);
        visit.add(start);
        while (queue.size() != 0) {
            key = queue.get(0);
            queue.remove(0);
            ArrayList<String> list = map.get(key);
            for (String str : list) {
                if (visit.indexOf(str) == -1) {
                    queue.add(str);
                    visit.add(str);
                }
            }
            System.out.print(key + "\t");
        }
        System.out.println();
    }
}
